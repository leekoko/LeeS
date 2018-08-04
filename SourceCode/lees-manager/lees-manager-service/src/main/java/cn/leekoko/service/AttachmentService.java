package cn.leekoko.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface AttachmentService {
	String uploadFile(HttpServletRequest request, HttpServletResponse response, String path);
}
