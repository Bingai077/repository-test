package cn.bingai.practice01.demo03.project3pro.view;

import cn.bingai.practice01.demo03.project3pro.domain.Employee;
import cn.bingai.practice01.demo03.project3pro.domain.Programmer;
import cn.bingai.practice01.demo03.project3pro.service.NameListService;
import cn.bingai.practice01.demo03.project3pro.service.TeamException;
import cn.bingai.practice01.demo03.project3pro.service.TeamService;

public class TeamView {
    
    private NameListService listSvc = new NameListService();
    private TeamService teamSvc = new TeamService();

    //主界面显示及控制方法
    public void enterMainMenu() {

        boolean loopFlag = true;
        char menu = 0;

        while (loopFlag) {
            if(menu != '1'){
                listAllEmployees();
            }

            System.out.println("1-团队列表 2-添加团队成员 3-删除团队成员 4-退出  请选择(1-4): ");
            menu = TSUtility.readMenuSelection();
            switch (menu) {
                case '1':
                    getTeam();
                    break;
                case '2':
                    addMember();
                    break;
                case '3':
                    deleteMember();
                    break;
                case '4':
                    System.out.println("确认是否退出(Y/N):");
                    char isExit = TSUtility.readConfirmSelection();
                    if(isExit == 'Y'){
                        loopFlag = false;
                    }
                    break;
            }
        }

    }

    //显示所有员工信息
    private void listAllEmployees() {
        System.out.println("============================开发成员团队调度软件============================\n");
        Employee[] employees = listSvc.getAllEmployees();
        if(employees == null || employees.length == 0){
            System.out.println("公司中没有任何员工信息！");
        }else{
            System.out.println("ID" + " \t" + "姓名" + " \t" + "年龄" + "\t" + "工资" + "  \t\t" + "职位" + " \t" + "状态" + " \t" + "奖金" + " \t" + "股票" + " \t" + "领用设备");
            for (int i = 0; i < employees.length; i++) {
                System.out.println(employees[i]);
            }
        }

        System.out.println("===========================================================================");
    }

    //显示团队成员列表操作
    private void getTeam() {
        //System.out.println("查看团队列表");
        System.out.println("========================团队成员列表========================\n");

        Programmer[] team = teamSvc.getTeam();
        if(team == null || team.length == 0){
            System.out.println("开发团队目前没有成员！");
        }else{
            System.out.println("TID/ID" + " \t" + "姓名" + " \t" + "年龄" + "\t" + "工资" + "  \t\t" + "职位"  + " \t" + "奖金" + " \t\t" + "股票");
            for (int i = 0; i < team.length ; i++) {
                System.out.println(team[i].getDetailsForTeam());
            }
        }

        System.out.println("===========================================================");
    }

    //实现添加成员操作
    private void addMember() {
//        System.out.println("添加团队成员");
        System.out.println("===================添加成员===================");
        System.out.println("请输入要添加的员工ID：");
        int id = TSUtility.readInt();
        Employee emp = null;
        try {
            emp = listSvc.getEmployee(id);
            teamSvc.addMember(emp);
            System.out.println("添加成功");
        } catch (TeamException e) {
            System.out.println("添加失败，原因：" + e.getMessage());;
        }
        //按回车键继续...
        TSUtility.readReturn();
    }

    //实现删除成员操作
    private void deleteMember() {
//        System.out.println("删除团队成员");
        System.out.println("===================删除成员===================");
        System.out.println("请输入要删除的员工TID：");
        int menberId = TSUtility.readInt();

        System.out.println("确认是否删除(Y/N):");
        char isDelete = TSUtility.readConfirmSelection();
        if(isDelete == 'N'){
            return;
        }

        try {
            teamSvc.removeMember(menberId);
            System.out.println("删除成功");
        } catch (TeamException e) {
            System.out.println("删除失败，原因：" + e.getMessage());
        }
        //按回车键继续...
        TSUtility.readReturn();

    }

    public static void main(String[] args) {
        TeamView view = new TeamView();
        view.enterMainMenu();
    }

}
