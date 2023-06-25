package com.itheima.jdbc;

import com.sun.glass.ui.Clipboard;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class MyFrame extends JFrame {                        //frame 类
    STUDENT stu = new STUDENT();
    static JFrame frame= new JFrame("学生管理系统");
    public MyFrame(String title){
        super(title);
        //设置框架
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,490);
        frame.setLocation(500,300);//在屏幕中设置显示的位置
        frame.setVisible(true);
        frame.setLayout(null);
        frame.setResizable(false);
        frame.setLayout(null);
        //设置按钮和文本
        JButton button1 = new JButton("增加学生");
        JButton button2 = new JButton("删除学生");
        JButton button3 = new JButton("修改数据 ");
        JButton button4 = new JButton("查看学生");
        Font f=new Font("宋体",Font.BOLD,25);  //按钮大小
        button1.setFont(f);
        button2.setFont(f);
        button3.setFont(f);
        button4.setFont(f);
        JLabel l1 = new JLabel("学生管理系统");           //文本大小和格式
        JLabel MyName = new JLabel("作者：付大恒");
        Font font = new Font("仿宋", Font.PLAIN, 30);
        l1.setBounds(300, 25, 180, 180);
        MyName.setBounds(0,0,300,30);
        l1.setFont(font);
        l1.setForeground(new Color(255,128,128));
        //按钮和文本添加到frame中
        button1.setBounds(0,200, 400, 125);
        button2.setBounds(400,200, 400, 125);
        button3.setBounds(0,325, 400, 125);
        button4.setBounds(400,325, 400, 125);
        frame.add(l1);
        frame.add(MyName);
        frame.add(button1);
        frame.add(button2);
        frame.add(button3);
        frame.add(button4);

        /*
        * 事件监听部分*/

        //按钮1事件监听
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                closThis();
                //创建新的窗口
                Add_Windows();
            }
        });
        //按钮2事件监听
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                closThis();
                //创建新的窗口
                Delete_Windows();
            }
        });
        //按钮3事件监听
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                closThis();
                //创建新的窗口
                Update_Windows();
            }
        });
        //按钮4事件监听
        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                closThis();
                //创建新的窗口
                try {
                    Select_Windows();
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }

    //添加学生界面
    public void Add_Windows(){
        /*
        * 初始化界面部分*/
        JFrame frame1 = new JFrame("添加学生");
        //设置在屏幕的位置
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setSize(800,490);
        frame1.setLocation(500,300);//在屏幕中设置显示的位置
        frame1.setVisible(true);
        frame1.setLayout(null);
        frame1.setResizable(false);
        frame1.setLayout(null);
        //设置按钮
        JButton button1 = new JButton("添加");
        JButton button2 = new JButton("返回");
        Font f=new Font("宋体",Font.BOLD,25);  //按钮大小
        button1.setFont(f);
        button2.setFont(f);
        button1.setBounds(250,375,100 , 50);
        button2.setBounds(425,375,100 , 50);
        //设置文本框,并添加标签

        Font font = new Font("仿宋", Font.BOLD, 20);
        JLabel SnoLabel = new JLabel("学号");             //学号
        SnoLabel.setBounds(240,50,100,30);
        SnoLabel.setFont(font);
        SnoLabel.setForeground(new Color(98,98,255));
        JTextField Sno = new JTextField(20);
        Sno.setBounds(290, 50, 200, 30);

        JLabel SameLabel = new JLabel("姓名");            //名字
        SameLabel.setBounds(240,90,100,30);
        SameLabel.setFont(font);
        SameLabel.setForeground(new Color(98,98,255));
        JTextField Sname = new JTextField(20);
        Sname.setBounds(290, 90, 200, 30);

        JLabel Sealable = new JLabel("姓别");            //性别
        Sealable.setBounds(240,130,100,30);
        Sealable.setFont(font);
        Sealable.setForeground(new Color(98,98,255));
        JTextField Ssex = new JTextField(20);
        Ssex.setBounds(290, 130, 200, 30);

        JLabel SageLabel = new JLabel("年龄");            //年龄
        SageLabel.setBounds(240,170,100,30);
        SageLabel.setFont(font);
        SageLabel.setForeground(new Color(98,98,255));
        JTextField Sage = new JTextField(20);
        Sage.setBounds(290, 170, 200, 30);

        JLabel SdeptLable = new JLabel("系名");            //系
        SdeptLable.setBounds(240,210,100,30);
        SdeptLable.setFont(font);
        SdeptLable.setForeground(new Color(98,98,255));
        JTextField Sdept = new JTextField(20);
        Sdept.setBounds(290, 210, 200, 30);

        JLabel SgpLabel = new JLabel("绩点");            //绩点
        SgpLabel.setBounds(240,250,100,30);
        SgpLabel.setFont(font);
        SgpLabel.setForeground(new Color(98,98,255));
        JTextField Sgpa = new JTextField(20);
        Sgpa.setBounds(290, 250, 200, 30);
        //加载控件
        frame1.add(button1);
        frame1.add(button2);
        frame1.add(Sno);
        frame1.add(Sname);
        frame1.add(Ssex);
        frame1.add(Sage);
        frame1.add(Sdept);
        frame1.add(Sgpa);
        frame1.add(SnoLabel);
        frame1.add(SameLabel);
        frame1.add(Sealable);
        frame1.add(SageLabel);
        frame1.add(SdeptLable);
        frame1.add(SgpLabel);

        /*
        * 事件监听部分*/
        //按钮1获取信息
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){

                //获取文本框信息
                boolean validInput = false;
                while (!validInput) {
                    try {
                        SQL_STU sql = new SQL_STU();
                        sql.AddTo(Sno, Sname, Ssex, Sage, Sdept, Sgpa);
                        validInput = true; // 输入正确，设置 validInput 为 true，跳出循环
                    } catch (Exception I) {
                        System.out.println("???");
                        JLabel WarnLabel = new JLabel("请输入正确信息!");
                        Font font = new Font("仿宋", Font.BOLD, 20);
                        WarnLabel.setBounds(0, 20, 800, 30);
                        WarnLabel.setFont(font);
                        WarnLabel.setForeground(new Color(234, 5, 5));
                        frame1.add(WarnLabel);
                        frame1.repaint(); // 刷新界面

                        validInput = false; // 输入错误，继续循环等待重新输入
                        break; // 添加 break 语句，跳出循环
                    }
                }

                if (validInput) {

                    JButton SuccessButton = new JButton("添加成功,继续添加");
                    Font fon = new Font("仿宋", Font.BOLD, 30);
                    SuccessButton.setBounds(0, 0, 180, 80);
                    frame1.add(SuccessButton);
                    frame1.repaint(); // 刷新界面
                    SuccessButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            frame1.dispose();
                            Add_Windows();
                        }
                    });
                }
            }
        });

        //按钮2返回事件监听
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame1.dispose();
                new MyFrame("学生管理系统");
            }
        });
    }
    //删除学生界面
    public void Delete_Windows(){
        JFrame frame2 = new JFrame("删除学生");
        //设置在屏幕的位置
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame2.setSize(800,490);
        frame2.setLocation(500,300);//在屏幕中设置显示的位置
        frame2.setVisible(true);
        frame2.setLayout(null);
        frame2.setResizable(false);
        frame2.setLayout(null);
        //编辑界面1
        Font font = new Font("仿宋", Font.BOLD, 20);
        JLabel IdLabel = new JLabel("请输入学号以删除：");
        IdLabel.setBounds(100,50,600,30);
        IdLabel.setFont(font);
        IdLabel.setForeground(new Color(98,98,255));
        JTextField Id = new JTextField(20);
        Id.setBounds(290, 50, 200, 30);
        JButton DeleteButton = new JButton("删除");
        JButton BackButton = new JButton("返回");
        DeleteButton.setBounds(250,375,100 , 50);
        BackButton.setBounds(425,375,100 , 50);
        frame2.add(IdLabel);
        frame2.add(Id);
        frame2.add(DeleteButton);
        frame2.add(BackButton);
        /*
        * 事件监听部分*/
        //1.删除
        DeleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean Index;
                String GetId = Id.getText();
                System.out.println(GetId);
                SQL_STU SqlDelete = new SQL_STU();
                try {
                    Index = SqlDelete.Delete(GetId);
                    if (Index) {
                        frame2.dispose();
                        JOptionPane.showMessageDialog(null, "删除成功！", "提示", JOptionPane.INFORMATION_MESSAGE);
                        Delete_Windows();
                    } else {
                        frame2.dispose();
                        JOptionPane.showMessageDialog(null, "未找到匹配的学生记录", "提示", JOptionPane.INFORMATION_MESSAGE);
                        Delete_Windows();
                    }

                    System.out.println("成功!");
                } catch (Exception ex) {
                    System.out.println("wanduzi");
                }

            }
        });
        //2.返回
        BackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame2.dispose();
                new MyFrame("学生管理系统");
            }
        });


    }
    //修改数据界面
    public void Update_Windows(){
        JFrame frame3 = new JFrame("修改数据");
        //设置在屏幕的位置
        frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame3.setSize(800,490);
        frame3.setLocation(500,300);//在屏幕中设置显示的位置
        frame3.setVisible(true);
        frame3.setLayout(null);
        frame3.setResizable(false);
        frame3.setLayout(null);
        //编辑页面1
        Font font = new Font("仿宋", Font.BOLD, 20);
        JLabel IdLabel = new JLabel("请输入学号以修改：");
        IdLabel.setBounds(100,50,600,30);
        IdLabel.setFont(font);
        IdLabel.setForeground(new Color(98,98,255));
        JTextField Id = new JTextField(20);
        Id.setBounds(290, 50, 200, 30);
        JButton UpdateButton = new JButton("修改");
        JButton BackButton = new JButton("返回");
        UpdateButton.setBounds(250,375,100 , 50);
        BackButton.setBounds(425,375,100 , 50);
        frame3.add(IdLabel);
        frame3.add(Id);
        frame3.add(UpdateButton);
        frame3.add(BackButton);
        //事件监听：修改和返回
        UpdateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //获得主码Sno-Id
                String GetId = Id.getText();
                System.out.println(GetId);
                //生成界面2
                JFrame Newframe = new JFrame("添加学生");
                //设置在屏幕的位置
                frame3.dispose();
                Newframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                Newframe.setSize(800,490);
                Newframe.setLocation(500,300);//在屏幕中设置显示的位置
                Newframe.setVisible(true);
                Newframe.setLayout(null);
                Newframe.setResizable(false);
                Newframe.setLayout(null);
                //设置按钮
                JButton button1 = new JButton("修改");
                JButton button2 = new JButton("返回");
                Font f=new Font("宋体",Font.BOLD,25);  //按钮大小
                button1.setFont(f);
                button2.setFont(f);
                button1.setBounds(250,375,100 , 50);
                button2.setBounds(425,375,100 , 50);
                //设置文本框,并添加标签

                Font font = new Font("仿宋", Font.BOLD, 20);
                JLabel SnoLabel = new JLabel("学号");             //学号
                SnoLabel.setBounds(240,50,100,30);
                SnoLabel.setFont(font);
                SnoLabel.setForeground(new Color(98,98,255));
                JTextField Sno = new JTextField(20);
                Sno.setBounds(290, 50, 200, 30);

                JLabel SameLabel = new JLabel("姓名");            //名字
                SameLabel.setBounds(240,90,100,30);
                SameLabel.setFont(font);
                SameLabel.setForeground(new Color(98,98,255));
                JTextField Sname = new JTextField(20);
                Sname.setBounds(290, 90, 200, 30);

                JLabel Sealable = new JLabel("姓别");            //性别
                Sealable.setBounds(240,130,100,30);
                Sealable.setFont(font);
                Sealable.setForeground(new Color(98,98,255));
                JTextField Ssex = new JTextField(20);
                Ssex.setBounds(290, 130, 200, 30);

                JLabel SageLabel = new JLabel("年龄");            //年龄
                SageLabel.setBounds(240,170,100,30);
                SageLabel.setFont(font);
                SageLabel.setForeground(new Color(98,98,255));
                JTextField Sage = new JTextField(20);
                Sage.setBounds(290, 170, 200, 30);

                JLabel SdeptLable = new JLabel("系名");            //系
                SdeptLable.setBounds(240,210,100,30);
                SdeptLable.setFont(font);
                SdeptLable.setForeground(new Color(98,98,255));
                JTextField Sdept = new JTextField(20);
                Sdept.setBounds(290, 210, 200, 30);

                JLabel SgpLabel = new JLabel("绩点");            //绩点
                SgpLabel.setBounds(240,250,100,30);
                SgpLabel.setFont(font);
                SgpLabel.setForeground(new Color(98,98,255));
                JTextField Sgpa = new JTextField(20);
                Sgpa.setBounds(290, 250, 200, 30);
                //加载控件
                Newframe.add(button1);
                Newframe.add(button2);
                Newframe.add(Sno);
                Newframe.add(Sname);
                Newframe.add(Ssex);
                Newframe.add(Sage);
                Newframe.add(Sdept);
                Newframe.add(Sgpa);
                Newframe.add(SnoLabel);
                Newframe.add(SameLabel);
                Newframe.add(Sealable);
                Newframe.add(SageLabel);
                Newframe.add(SdeptLable);
                Newframe.add(SgpLabel);
                //在文本框上输入查询结果
                SQL_STU sql = new SQL_STU();
                STUDENT TextStu = new STUDENT();
                try {
                    TextStu = sql.SelectById(GetId);
                    if (TextStu != null) {
                        Sno.setEditable(false);
                        Sno.setText(TextStu.Sno);
                        Sname.setText(TextStu.Sname);
                        Ssex.setText(TextStu.Ssex);
                        Sage.setText(String.valueOf(TextStu.Sage));
                        Sdept.setText(TextStu.Sdept);
                        Sgpa.setText(String.valueOf(TextStu.Sgpa));
                    } else {
                        // 查询结果为空，进行相应的提示或处理
                        Newframe.dispose();
                        JOptionPane.showMessageDialog(null, "未找到匹配的学生记录", "提示", JOptionPane.INFORMATION_MESSAGE);
                        Update_Windows();
                    }
                } catch (Exception ex) {
                    // 查询出现异常，进行相应的提示或处理
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "查询学生信息时出现异常", "错误", JOptionPane.ERROR_MESSAGE);
                }
                //事件监听1更新
                button1.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        SQL_STU Supdate = new SQL_STU();
                        try {
                            Supdate.UPDATE(Sno,Sname,Ssex,Sage,Sdept,Sgpa);
                            Newframe.dispose();
                            JOptionPane.showMessageDialog(null, "修改成功！", "提示", JOptionPane.INFORMATION_MESSAGE);
                            Update_Windows();
                            System.out.println("成功!");
                        } catch (Exception exception) {
                            System.out.println("失败");
                        }
                    }
                });
                //事件监听2返回
                button2.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Newframe.dispose();
                        Update_Windows();
                    }
                });
            }
        });
        //返回
        BackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame3.dispose();
                new MyFrame("学生管理系统");
            }
        });


    }
    //查看学生
    public void Select_Windows() throws Exception {
        JFrame frame4 = new JFrame("查看学生");
        //设置在屏幕的位置
        frame4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame4.setSize(800,490);
        frame4.setLocation(500,300);//在屏幕中设置显示的位置
        frame4.setVisible(true);
        frame4.setLayout(null);
        frame4.setResizable(false);
        frame4.setLayout(new BorderLayout());
        //创建表格
        SQL_STU SQL = new SQL_STU();


        Object[][] data = SQL.getDataAsArray();

        // 创建表格列名
        String[] columnNames = {"Sno", "Sname", "Ssex","Sage","Sdept","Sgpa"};
        JTable table = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(table);
        frame4.getContentPane().add(scrollPane);
        JButton button1 = new JButton("返回");
        Font f=new Font("宋体",Font.BOLD,25);  //按钮大小
        button1.setFont(f);
        button1.setPreferredSize(new Dimension(10, 50));
        frame4.add(button1,BorderLayout.SOUTH);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame4.dispose();
                new MyFrame("学生管理系统");
            }
        });

    }

    public static void closThis(){
        frame.dispose();
    }
    //获取数据方法
}
