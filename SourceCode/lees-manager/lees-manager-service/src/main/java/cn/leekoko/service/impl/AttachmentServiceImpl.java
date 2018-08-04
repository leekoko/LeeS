package cn.leekoko.service.impl;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.alibaba.druid.support.json.JSONUtils;

import cn.leekoko.service.AttachmentService;
@Service
public class AttachmentServiceImpl implements AttachmentService {
	
	@Value("${uploadPath}")
	public String uploadPath;
	
	public String uploadFile(HttpServletRequest request, HttpServletResponse response, String path) {
        response.setCharacterEncoding( "UTF-8" );
        Integer chunk = null; /* 分割块数 */
        Integer chunks = null; /* 总分割数 */
        String tempFileName = null; /* 临时文件名 */
        String newFileName = null; /* 最后合并后的新文件名 */
        BufferedOutputStream outputStream = null;
        
        if(StringUtils.isNoneEmpty(uploadPath)){    //有配置好
        	uploadPath = uploadPath + path; 
        }else{
        	uploadPath = request.getServletContext().getRealPath(path);
        }
        File up = new File(uploadPath);
        if (!up.exists()){
            up.mkdir();
        }
        
        if ( ServletFileUpload.isMultipartContent( request ) )
        {
            try {
                DiskFileItemFactory factory = new DiskFileItemFactory();
                factory.setSizeThreshold( 1024 );
                /* factory.setRepository(new File(repositoryPath));// 设置临时目录 */
                ServletFileUpload upload = new ServletFileUpload( factory );
                upload.setHeaderEncoding( "UTF-8" );
                /* upload.setSizeMax(5 * 1024 * 1024);// 设置附件最大大小，超过这个大小上传会不成功 */
                List<FileItem> items = upload.parseRequest( request );
                for ( FileItem item : items ){
                    if ( item.isFormField() ){
                        if ( item.getFieldName().equals( "name" )){
                            tempFileName = item.getString();
                            /* System.out.println("临时文件名：" + tempFileName); */
                        }else if ( item.getFieldName().equals( "chunk" )){
                            chunk = Integer.parseInt( item.getString() );
                            /* System.out.println("当前文件块：" + (chunk + 1)); */
                        }else if ( item.getFieldName().equals( "chunks" )){
                            chunks = Integer.parseInt( item.getString() );
                            /* System.out.println("文件总分块：" + chunks); */
                        }
                    }else{ /* 如果是文件类型 */
                        if ( tempFileName != null ){
                            String chunkName = tempFileName;
                            if ( chunk != null )
                            {
                                chunkName = chunk + "_" + tempFileName;
                            }
                            newFileName = Date2FileName("yyyyMMddhhmmss", "").concat( FilenameUtils.getExtension( tempFileName ) );
                            File savedFile = new File( uploadPath, newFileName );
                            item.write( savedFile );
                        }
                    }
                }

/*                newFileName = UUID.randomUUID().toString().replace( "-", "" )
                          .concat( "." )
                          .concat( FilenameUtils.getExtension( tempFileName ) );*/
                if ( chunk != null && chunk + 1 == chunks )
                {
                    outputStream = new BufferedOutputStream(
                        new FileOutputStream( new File( uploadPath, newFileName ) ) );
                    /* 遍历文件合并 */
                    for ( int i = 0; i < chunks; i++ )
                    {
                        File tempFile = new File( uploadPath, i + "_" + tempFileName );
                        byte[] bytes = FileUtils.readFileToByteArray( tempFile );
                        outputStream.write( bytes );
                        outputStream.flush();
                        tempFile.delete();
                    }
                    outputStream.flush();
                }
                Map<String, Object> m = new HashMap<String, Object>();
                m.put( "status", true );
                m.put( "fileUrl", path + "\\"+ newFileName );
                response.getWriter().write( JSONUtils.toJSONString(m) );
            } catch ( FileUploadException e ) {
                e.printStackTrace();
                Map<String, Object> m = new HashMap<String, Object>();
                m.put( "status", false );
                try {
					response.getWriter().write( JSONUtils.toJSONString(m) );
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            } catch ( Exception e ) {
                e.printStackTrace();
                Map<String, Object> m = new HashMap<String, Object>();
                m.put( "status", false );
                try {
					response.getWriter().write( JSONUtils.toJSONString(m) );
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            } finally {
                try {
                    if ( outputStream != null )
                        outputStream.close();
                } catch ( IOException e ) {
                    e.printStackTrace();
                }
            }
        }
        return uploadPath + "\\" + newFileName;
	}
	
    /**
     * 获取文件名
     * @param nameFormat
     * @param fileType
     * @return
     */
	public String Date2FileName(String nameFormat, String fileType) {
		Date date = new Date(System.currentTimeMillis());
		SimpleDateFormat dateFormat = new SimpleDateFormat(nameFormat);
		String fileName = dateFormat.format(date) + "." + fileType;
		return fileName;
	}
}
