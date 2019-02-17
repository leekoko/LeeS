package com.lees.templategeneration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Scanner;

//@SpringBootApplication
public class TemplateGenerationApplication {

    static ArrayList<String> strArr = new ArrayList<String>();

    public static void main(String[] args) {
//        SpringApplication.run(TemplateGenerationApplication.class, args);
        //定义模板的类型
        initModel();

        //显示模板
        showModel();
    }


    /**
     * 显示模板
     */
    private static void showModel() {
        for (int i = 0; i < strArr.size(); i++) {
            System.out.println(strArr.get(i));
        }
    }

    /**
     * 定义模板
     */
    private static void initModel() {
        System.out.println("请输入模板，end结束:");
        Scanner scanner = new Scanner(System.in);
        String inStr = "            <div class=\"matters-content-part\">\n" +
                "                <h2 id=\"matters-part1\" class=\"matters-subtitle\">政策依据</h2>\n" +
                "                <p class=\"matters-truncate\">\n" +
                "                    《广州市黄埔区 广州开发区促进高新技术产业发展办法》（穗开管办〔2017〕7号）、《广州开发区 黄埔区科技发展资金管理办法》（穗开管办〔2016〕28号）。\n" +
                "                </p>\n" +
                "            </div>";
        while (!(inStr = scanner.next()).equals("end")){
            strArr.add(inStr);
        }
    }
}
