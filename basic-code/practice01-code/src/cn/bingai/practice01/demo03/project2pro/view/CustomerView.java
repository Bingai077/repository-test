package cn.bingai.practice01.demo03.project2pro.view;

import cn.bingai.practice01.demo03.project2pro.bean.Customer;
import cn.bingai.practice01.demo03.project2pro.service.CustomerList;
import cn.bingai.practice01.demo03.project2pro.util.CMUtility;

/**
 * @Description Customer为实体对象，用来封装客户信息
 */
public class CustomerView {

    private CustomerList customerList = new CustomerList(10);

    public CustomerView() {
        Customer customer = new Customer("斌改",'男',18,"18855558888","1111@163.com");
        customerList.addCustomer(customer);
    }

    /**
     * @Description 显示主菜单，响应用户输入，根据用户操作分别调用其他相应的成员方法
     * （如addNewCustomer），以完成客户信息处理。
     */
    public void enterMainMenu() {

        boolean isFlag = true;
        while (isFlag) {
            System.out.println("\n=============客户信息管理软件=============");
            System.out.println("               1 添加客户");
            System.out.println("               2 修改客户");
            System.out.println("               3 删除客户");
            System.out.println("               4 客户列表");
            System.out.println("               5 退  出\n");
            System.out.print("     请选择(1-5): ");

            char mune = CMUtility.readMenuSelection();
            switch (mune) {
                case '1':
                    addNewCustomer();
                    break;
                case '2':
                    modifyCustomer();
                    break;
                case '3':
                    deleteCustomer();
                    break;
                case '4':
                    listAllCustomers();
                    break;
                case '5':
                    System.out.println("确认是否退出(Y/N):");
                    char isExit = CMUtility.readConfirmSelection();
                    if (isExit == 'Y') {
                        isFlag = false;
                    }
            }

        }

    }

    private void addNewCustomer() {
        //System.out.println("添加客户");
        System.out.println("===============添加客户===============");
        System.out.println("姓名：");
        String name = CMUtility.readString(10);
        System.out.println("性别：");
        char gender = CMUtility.readChar();
        System.out.println("年龄：");
        int age = CMUtility.readInt();
        System.out.println("电话：");
        String phone = CMUtility.readString(13);
        System.out.println("邮箱：");
        String email = CMUtility.readString(30);

        //将上述数据封装到对象中
        Customer customer = new Customer(name, gender, age, phone, email);
        boolean isSuccess = customerList.addCustomer(customer);
        if (isSuccess) {
            System.out.println("===============添加完成===============");
        } else {
            System.out.println("==========客户目录已满，添加失败==========");

        }

    }

    private void modifyCustomer() {
        //System.out.println("修改客户");
        System.out.println("===============修改客户===============");

        Customer customer;
        int number;
        for (; ; ) {
            System.out.println("请选择待修改客户编号(-1)退出：");
             number = CMUtility.readInt();

            if (number == -1) {
                return;
            }
            customer = customerList.getCustomer(number - 1);//用户操作number
            if (customer == null) {
                System.out.println("无法找到指定客户！");
            } else {//找到相应编号客户
                break;
            }
        }

        //修改客户信息
        System.out.println("姓名(" + customer.getName() + "):");
        String name = CMUtility.readString(10, customer.getName());
        System.out.println("性别(" + customer.getGender() + "):");
        char gender = CMUtility.readChar(customer.getGender());
        System.out.println("年龄(" + customer.getAge() + "):");
        int age = CMUtility.readInt(customer.getAge());
        System.out.println("电话(" + customer.getPhone() + "):");
        String phone = CMUtility.readString(13, customer.getPhone());
        System.out.println("邮箱(" + customer.getEmail() + "):");
        String email = CMUtility.readString(30, customer.getEmail());

        Customer newCust = new Customer(name, gender, age, phone, email);

        boolean isReplaced = customerList.replaceCustomer(number - 1, newCust);
        if(isReplaced){
            System.out.println("===============修改成功===============");
        }else{
            System.out.println("===============修改失败===============");
        }


    }

    private void deleteCustomer() {
        //System.out.println("删除客户");
        System.out.println("===============删除客户===============");

        int num;
        for(;;){
            System.out.println("请选择待修改客户编号(-1)退出：");
            num = CMUtility.readInt();
            if(num == -1){
                return;
            }

            Customer customer = customerList.getCustomer(num - 1);
            if(customer == null){
                System.out.println("无法找到指定客户");
            }else{
                break;
            }

        }

        //找到了指定客户
        System.out.println("确认是否删除(Y/N):");
        char isDelete = CMUtility.readConfirmSelection();
        if(isDelete == 'Y'){
            boolean deleteSuccess = customerList.deleteCustomer(num - 1);
            if(deleteSuccess){
                System.out.println("===============删除成功===============");
            }else{
                System.out.println("===============删除失败===============");
            }
        }else {
            return;
        }


    }

    private void listAllCustomers() {
//        System.out.println("客户列表");
        System.out.println("\n=============================客户列表=============================");

        int total = customerList.getTotal();
        if (total == 0) {
            System.out.println("没有客户记录！");
        } else {
            System.out.println("编号\t\t姓名\t\t性别\t\t年龄\t\t电话\t\t\t\t邮箱");
            Customer[] customers = customerList.getAllCustomers();
            for (int i = 0; i < customers.length; i++) {
                Customer cus = customers[i];
                System.out.println((i + 1) + "\t\t" + cus.getName() + "\t\t" +
                        cus.getGender() + "\t\t" + cus.getAge() + "\t\t" +
                        cus.getPhone() + "\t\t" + cus.getEmail());
            }
        }

        System.out.println("===========================客户列表完成===========================");


    }

    public static void main(String[] args) {
        CustomerView view = new CustomerView();
        view.enterMainMenu();

    }


}
