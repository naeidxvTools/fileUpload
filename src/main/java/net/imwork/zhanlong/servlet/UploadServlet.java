package net.imwork.zhanlong.servlet;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;
@WebServlet(name = "UploadServlet", urlPatterns = "/UploadServlet")
public class UploadServlet extends HttpServlet
{
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        DiskFileItemFactory factory = new DiskFileItemFactory(); //磁盘文件条目工厂

//        String path = request.getRealPath("upload");         //在web文件下建一个upload文件件 ,已过时
//        String path = request.getSession().getServletContext().getRealPath("upload");
        String path = request.getServletContext().getRealPath("upload");

        System.out.println("path = " + path);

        factory.setRepository(new File(path)); //临时文件目录
        factory.setSizeThreshold(1024 * 1024);

        ServletFileUpload upload = new ServletFileUpload(factory);

        try
        {
            List<FileItem> list = upload.parseRequest(request);

            for (FileItem item : list)
            {
                String fieldName = item.getFieldName();
                if (item.isFormField())
                {
                    String fieldValue = item.getString();
                    request.setAttribute(fieldName, fieldValue);
                }else
                {
                    String tempFileName = item.getName(); //上传文件的名字
                    int start = tempFileName.lastIndexOf("\\");
                    String fileName = tempFileName.substring(start + 1);
                    request.setAttribute(fieldName,fileName);

//                    item.write(new File(path,fileName));   //文件上传

                    OutputStream os = new FileOutputStream(new File(path, fileName)); //文件上传
                    InputStream is = item.getInputStream();
                    byte[] buffer = new byte[1024];
                    int length = 0;
                    while (-1 != (length = is.read(buffer)))
                    {
                        os.write(buffer,0, length);
                    }
                }
            }

        } catch (Exception e)
        {
            e.printStackTrace();
        }

        request.getRequestDispatcher("fileUploadResult.jsp").forward(request, response);
    }
}
