package edu.nuaa.servlet.ZongZheServlet;

import edu.nuaa.factory.DaoFactory;
import edu.nuaa.vo.ZhouShiQiVo.AppInfo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SaveExcelServlet extends HttpServlet {
    public SaveExcelServlet() {
        super();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        this.doGet(request, response);
    }
    //前端需要传递到这个servlet中的数据有用户名（能直接是用户id最好），应用名，Excel文件路径
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         //接受前端信息
        request.setCharacterEncoding("utf-8");
        String appname = request.getParameter("appname");//获取应用名称
        String excelpath = request.getParameter("excelpath");//获取excel文件路径
        int userid=Integer.parseInt(request.getParameter("userid"));//获取用户id
        String username=request.getParameter("username");//获取用户名称
        //用户id和用户名称只保留一个就可以，如果可以直接从前端获取用户id最好，不能就先获取用户名称，然后由徐阳获取用户id

        //Written by Xu
        //获取用户id

        //Written by Zhou
        //存储应用信息
        AppInfo ai = new AppInfo();
        ai.setUserId(userid);
        ai.setAppName(appname);
        ai.setDataName(appname+"原始数据集");
        try {
            DaoFactory.getAppInfoDaoInstance().doCreate(ai);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //Written by Zong 2017 12 3
        //存储数据集文件
        try {
            DaoFactory.getExcelDaoInstance().saveExcelToMysql(appname+"原始数据集",excelpath);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
