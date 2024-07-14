/**
 * @Author Eman Hashim
 * Project Name   Spring Boot Serious For Beginners
 * Date : 7/14/2024
 * Time: 1:13 AM
 */


package com.example.demo.Report;

import com.example.demo.student.Student;
import com.example.demo.student.StudentRepository;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ReportService1 {

    String v = "C:\\Users\\hp\\Desktop\\JasperReportStore ";

    @Autowired
private StudentRepository studentRepository;

    public String exportReport(String reportFormat) throws FileNotFoundException, JRException {

        List<Student> students = studentRepository.findAll();
        //load file and compile it
        File file  = ResourceUtils.getFile("classpath:Spring_Serious.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(students);

        Map<String,Object> parameters= new HashMap<>();
        parameters.put("created by", "Eman Hashim");

        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,parameters , dataSource);

            if(reportFormat.equalsIgnoreCase("html")){

                JasperExportManager.exportReportToHtmlFile(jasperPrint, v + "\\string.html");
            }

        if(reportFormat.equalsIgnoreCase("pdf")){

            JasperExportManager.exportReportToPdfFile(jasperPrint,v + "\\string.pdf");
        }

        return "report generated in path " + v;

    }


}
