
package invoices;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.table.*;

public class Invoices extends JFrame implements ActionListener{

    
    
    // thiết lập
  private final JButton btnihd,btnlm,btnthoat;
  private final JLabel lbct,lbdcct,lbtel,lbfax,lbweb,lbemail,lbmst,lbhd,lbngay,lbthang,lbnam,
          lbtkh,lbmhd,lbdc,lbsdt,lbttt,lbtc,lbgg,lbck,lbpt,
          lbtt,lbtbc,lbvat,lbkh,lbky1,lbky2,lbbb,lbvnd1,lbvnd2,lbvnd3;
  private final JComboBox cbongay,cbothang,cbonam;
  private final JScrollPane jsp;
  private DefaultComboBoxModel model,model1,model2;
  private HashMap hashMap;
  private JTable tbl,tblhd;
  DefaultTableModel model3;

  JFrame frame = new JFrame();

  JPanel p1 = new JPanel(null);
  
//Textfield
JTextField txttkh = new JTextField();
JTextField txtmhd = new JTextField();
JTextField txtdc = new JTextField();
JTextField txtsdt = new JTextField();
JTextField txttc = new JTextField();
JTextField txtgg = new JTextField();
JTextField txttt = new JTextField();
JTextField txttbc = new JTextField();
    
    public static void main(String[] args) {
      Invoices aaa = new Invoices();
    }

    public Invoices(){
         tblhd = new JTable();
        tblhd.setSize(775,70);
       tblhd.setLocation(50,235);
       tblhd.setFont(new Font("Times New Roman", 0, 14));
        frame.setVisible(true);
       frame.setSize(850,600);
       frame.setLocation(400,100);
       frame.setResizable(false);
       

       p1.setVisible(true);
       p1.setSize(850,800);
       p1.setLocation(0,0);
       
       frame.add(p1);

       
       frame.setTitle("Hóa đơn bán hàng công ty HKT Consultant");
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       p1.add(txttkh);
       p1.add(txtmhd);
       p1.add(txtdc);
       p1.add(txtsdt);
       p1.add(txttc);
       p1.add(txtgg);
       p1.add(txttt);
       p1.add(txttbc);

      
//       p1.add(tblhd);
      
       
       
//ComboBox              
       cbongay = new JComboBox();
       cbothang = new JComboBox();
       cbonam = new JComboBox();
       cbongay.setSize(40, 20);
       cbongay.setLocation(320,150);
       cbothang.setSize(40, 20);
       cbothang.setLocation(400, 150);
       cbonam.setSize(60, 20);
       cbonam.setLocation(475, 150);
       p1.add(cbongay);
       p1.add(cbothang);
       p1.add(cbonam);
//button       
       btnihd = new JButton("In hóa đơn");      
       btnlm = new JButton("Làm mới");
       btnthoat = new JButton("Thoát");
       btnihd.setSize(100,30);
       btnihd.setLocation(150,520);
       btnlm.setSize(100,30);
       btnlm.setLocation(350,520);
       btnthoat.setSize(100,30);
       btnthoat.setLocation(550,520);
       p1.add(btnihd);
       p1.add(btnlm);
       p1.add(btnthoat);
       
//       label
//ten cong ty     
       lbct = new JLabel("CÔNG TY CỔ PHẦN TƯ VẤN QUẢN TRỊ HKT");
       lbct.setSize(450,25);
       lbct.setLocation(200,10);
       lbct.setFont(new Font("Times New Roman",1,20));
//dia chi cong ty      
       lbdcct = new JLabel("A1-901, Tầng 9, Nhà A1, Tòa nhà OCT1, KĐT Resco");
       lbdcct.setSize(400, 20);
       lbdcct.setLocation(200,40);
       lbdcct.setFont(new Font("Times New Roman",0,12));
//sdt cong ty      
       lbtel = new JLabel("Tel: 043 7925 191");
       lbtel.setSize(100,20);
       lbtel.setLocation(200,60);
       lbtel.setFont(new Font("Times New Roman", 0, 12));
//fax cua cong ty       
       lbfax = new JLabel("Fax: 043 7925 191");
       lbfax.setSize(200,20);
       lbfax.setLocation(400,60);
       lbfax.setFont(new Font("Times New Roman", 0, 14));
//website cong ty       
       lbweb = new JLabel("Website: www.hktconsultant.vn");
       lbweb.setSize(200,20);
       lbweb.setLocation(200,80);
       lbweb.setFont(new Font("Times New Roman", 0, 14));
//email cong ty       
       lbemail = new JLabel("Email: hktconsultant@yahoo.com.vn");
       lbemail.setSize(300,20);
       lbemail.setLocation(400,80);
       lbemail.setFont(new Font("Times New Roman", 0, 14));
//mst cong ty       
       lbmst = new JLabel("MST: 0105149688");
       lbmst.setSize(200,20);
       lbmst.setLocation(200,100);
       lbmst.setFont(new Font("Times New Roman", 0, 14));
 //tieu de      
       lbhd = new JLabel("HÓA ĐƠN BÁN HÀNG");
       lbhd.setSize(300, 20);
       lbhd.setLocation(300, 130);
       lbhd.setFont(new Font("Times New Roman", 1, 20));
//ngay       
       lbngay = new JLabel("ngày");
       lbngay.setSize(50,20);
       lbngay.setLocation(290, 150);
       lbngay.setFont(new Font("Times New Roman", 0, 14));
 //thang      
       lbthang = new JLabel("tháng");
       lbthang.setSize(50, 20);
       lbthang.setLocation(365, 150);
       lbthang.setFont(new Font("Times New Roman", 0, 14));
//nam       
       lbnam = new JLabel("năm");
       lbnam.setSize(50, 20);
       lbnam.setLocation(445, 150);
       lbnam.setFont(new Font("Times New Roman", 0, 14));
//ten khach hang      
       lbtkh = new JLabel("Tên khách hàng : ");
       lbtkh.setSize(120, 20);
       lbtkh.setLocation(50, 170);
       lbtkh.setFont(new Font("Times New Roman", 1, 14));
//ten khach hang
       txttkh.setSize(150,20);
       txttkh.setLocation(160,170);
       txttkh.setFont(new Font("Times New Roman", 0, 14));
//ma hoa don       
       lbmhd = new JLabel("Mã hóa đơn: ");
       lbmhd.setSize(100, 20);
       lbmhd.setLocation(600, 170);
       lbmhd.setFont(new Font("Times New Roman",1, 14));
//ma hoa don
       txtmhd.setSize(150,20);
       txtmhd.setLocation(680,170);
       txtmhd.setFont(new Font("Times New Roman", 0, 14));
//dia chi
       lbdc = new JLabel("Địa chỉ               : ");
       lbdc.setSize(120, 20);
       lbdc.setLocation(50, 190);
       lbdc.setFont(new Font("Times New Roman", 1, 14));
//dia chi
       txtdc.setSize(150,20);
       txtdc.setLocation(160,190);
       txtdc.setFont(new Font("Times New Roman", 0, 14));
//so dien thoai      
       lbsdt = new JLabel("Số điện thoại      : ");
       lbsdt.setSize(120, 20);
       lbsdt.setLocation(50, 210);
       lbsdt.setFont(new Font("Times New Roman", 1, 14));
//so dien thoai
       txtsdt.setSize(150, 20);
       txtsdt.setLocation(160, 210);
       txtsdt.setFont(new Font("Times New Roman", 0, 14));
       
//table
 tblhd.setFont(new java.awt.Font("Times New Roman",0, 14)); // NOI18N
        tblhd.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null}
               
            },
            new String [] {
                "STT", "Tên sản phẩm", "Đơn vị tiền", "Số lượng", "Đơn giá", "CK(%)", "Tiền sau thuế(VNĐ)"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Long.class, java.lang.Long.class, java.lang.Long.class, java.lang.Long.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblhd.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        model3 =(DefaultTableModel) tblhd.getModel();   
       jsp = new JScrollPane();

       jsp.setSize(new Dimension(830, 70));
       jsp.setLocation( 10, 240);
       jsp.setViewportView(tblhd);
       
//tien truoc thue      
       lbttt = new JLabel("Tiền trước thuế = SL * Đơn giá * (1-CK%) Tiền sau thuế = Tiền trước thuế * (1 + Thuế%)");
       lbttt.setSize(550, 20);
       lbttt.setLocation(50,310);
       lbttt.setFont(new Font("Times New Roman", 0, 14));
//tong cong  
       lbtc = new JLabel("Tổng cộng: ");
       lbtc.setSize(100, 20);
       lbtc.setLocation(600, 310);
       lbtc.setFont(new Font("Times New Roman", 3, 14));
//tong cong
       txttc.setSize(130, 20);
       txttc.setLocation(670, 310);
       txttc.setEnabled(false);
       txttc.setFont(new Font("Times New Roman", 0, 14));
//don vi tien      
       lbvnd1 = new JLabel("VND");
       lbvnd1.setSize(50, 20);
       lbvnd1.setLocation(800, 310);
       lbvnd1.setFont(new Font("Times New Roman", 3, 14));
//chiet khau      
       lbck = new JLabel("Chiết khấu:");
       lbck.setSize(100, 20);
       lbck.setLocation(400, 330);
       lbck.setFont(new Font("Times New Roman", 3, 14));
//tinh %      
       lbpt = new JLabel("0%");
       lbpt.setSize(30, 20);
       lbpt.setLocation(520, 330);
       lbpt.setFont(new Font("Times New Roman", 3, 14));
//giam gia     
       lbgg = new JLabel("Giảm giá:");
       lbgg.setSize(100, 20);
       lbgg.setLocation(605, 330);
       lbgg.setFont(new Font("Times New Roman", 3, 14));
//giam gia
       txtgg.setSize(130,20);
       txtgg.setLocation(670, 330);
       txtgg.setEnabled(false);
       txtgg.setFont(new Font("Times New Roman", 0, 14));
//don vi tien       
       lbvnd2 = new JLabel("VND");
       lbvnd2.setSize(50, 20);
       lbvnd2.setLocation(800, 330);
       lbvnd2.setFont(new Font("Times New Roman", 3, 14));
//tong tien thanh toan      
       lbtt = new JLabel("Tổng tiền thanh toán: ");
       lbtt.setSize(200, 20);
       lbtt.setLocation(535, 350);
       lbtt.setFont(new Font("Times New Roman", 3, 14));
//tong tien thanh toan
       txttt.setSize(130, 20);
       txttt.setLocation(670, 350);
       txttt.setEnabled(false);
       txttt.setFont(new Font("Times New Roman", 0, 14));
//don vi tien       
       lbvnd3 = new JLabel("VND");
       lbvnd3.setSize(50, 20);
       lbvnd3.setLocation(800, 350);
       lbvnd3.setFont(new Font("Times New Roman", 3, 14));
//so tien bang chu      
       lbtbc = new JLabel("Số tiền bằng chữ: ");
       lbtbc.setSize(150, 20);
       lbtbc.setLocation(50, 380);
       lbtbc.setFont(new Font("Times New Roman", 0, 14));
//so tien bang chu
       txttbc.setSize(300, 20);
       txttbc.setLocation(150, 380);
       txttbc.setFont(new Font("Times New Roman", 0, 14));
//gia chua bao gom thue       
       lbvat = new JLabel("Giá trên chưa bao gồm thuế VAT 10%");
       lbvat.setSize(250, 20);
       lbvat.setLocation(50, 400);
       lbvat.setFont(new Font("Times New Roman", 0, 14));
//khach hang       
       lbkh = new JLabel("KHÁCH HÀNG");
       lbkh.setSize(100, 20);
       lbkh.setLocation(150, 430);
       lbkh.setFont(new Font("Times New Roman", 0, 14));
 //ky ten     
       lbky1 = new JLabel("(Ký, ghi rõ họ tên)");
       lbky1.setSize(150, 20);
       lbky1.setLocation(140, 450);
       lbky1.setFont(new Font("Times New Roman", 0, 14));
//ben ban       
       lbbb = new JLabel("BÊN BÁN");
       lbbb.setSize(100, 20);
       lbbb.setLocation(600, 430);
       lbbb.setFont(new Font("Times New Roman", 0, 14));
//ky ten       
       lbky2 = new JLabel("(Ký, ghi rõ họ tên)");
       lbky2.setSize(150, 20);
       lbky2.setLocation(590, 450);
       lbky2.setFont(new Font("Times New Roman", 0, 14));
       
       
    // panel 
    // lbct,lbdcct,lbtel,lbfax,lbweb,lbemail,lbmst,lbhd,lbngay,lbthang,lbnam,
    // lbtkh,lbmhd,lbdc,lbsdt,lbttt,lbtc,lbgg,lbck,lbpt,
    // lbtt,lbtbc,lbvat,lbkh,lbky1,lbky2,lbbb,lbvnd1,lbvnd2,lbvnd3;
    
       //label
     p1.add(lbct);
     p1.add(lbdcct);
     p1.add(lbtel);
     p1.add(lbfax);
     p1.add(lbweb);
     p1.add(lbemail);
     p1.add(lbmst);
     p1.add(lbhd);
     p1.add(lbngay);
     p1.add(lbthang);
     p1.add(lbnam);
     p1.add(lbtkh);
     p1.add(lbmhd);
     p1.add(lbdc);
     p1.add(lbsdt);
     p1.add(jsp);
     p1.add(lbttt);
     p1.add(lbtc);
     p1.add(lbvnd1);
     p1.add(lbck);
     p1.add(lbpt);
     p1.add(lbgg);
     p1.add(lbvnd2);
     p1.add(lbtt);
     p1.add(lbvnd3);
     p1.add(lbtbc);
     p1.add(lbvat);
     p1.add(lbkh);
     p1.add(lbky1);
     p1.add(lbbb);
     p1.add(lbky2);
       
      //button         
   
      
       btnihd.addActionListener(this);
       btnlm.addActionListener(this);
       btnthoat.addActionListener(this);

abc();
    
    }

  private void abc(){
//cbo ngay
           model = new DefaultComboBoxModel();
           model.addElement("1");
           model.addElement("2");
           model.addElement("3");
           model.addElement("4");
           model.addElement("5");
           model.addElement("6");
           model.addElement("7");
           model.addElement("8");
           model.addElement("9");
           model.addElement("10");
           model.addElement("11");
           model.addElement("12");
           model.addElement("13");
           model.addElement("14");
           model.addElement("15");
           model.addElement("16");
           model.addElement("17");
           model.addElement("18");
           model.addElement("19");
           model.addElement("20");
           model.addElement("21");
           model.addElement("22");
           model.addElement("23");
           model.addElement("24");
           model.addElement("25");
           model.addElement("26");
           model.addElement("27");
           model.addElement("28");
           model.addElement("29");
           model.addElement("30");
           model.addElement("31");
                      
           cbongay.setModel(model);
//cbothang         
         model1 = new DefaultComboBoxModel();
         model1.addElement("1");
         model1.addElement("2");
         model1.addElement("3");
         model1.addElement("4");
         model1.addElement("5");
         model1.addElement("6");
         model1.addElement("7");
         model1.addElement("8");
         model1.addElement("9");
         model1.addElement("10");
         model1.addElement("11");
         model1.addElement("12");
         
         cbothang.setModel(model1);
//cbonam
        model2 = new DefaultComboBoxModel();
        model2.addElement("2010");
        model2.addElement("2011");
        model2.addElement("2012");
        model2.addElement("2013");
        model2.addElement("2014");
        model2.addElement("2015");
        model2.addElement("2016");
        
        cbonam.setModel(model2);
       }
  
  
    @Override
    public void actionPerformed(ActionEvent e) {
       Object abb = e.getSource();
       if (abb == btnthoat)
           System.exit(0);
       if(abb == btnlm)
       {
           int click = JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn làm mới không"
                   + " toàn bộ dữ liệu bạn đã nhập sẽ mất hết ???","Cảnh báo",JOptionPane.YES_OPTION);
           if (click == JOptionPane.YES_OPTION){
           txttkh.setText("");
           txtmhd.setText("");
           txtdc.setText("");
           txtsdt.setText("");
           txttc.setText("");
           txtgg.setText("");
           txttt.setText("");
           txttbc.setText("");
           }
       }
       if(abb == btnihd)
       {
           String str[] = new String[15];
           hashMap = new HashMap();
            DefaultTableModel tableModel = new DefaultTableModel(str, 1);
             tbl = new JTable(tableModel);
        
        String[] values;
        values = new String[10];
        
           System.out.println(txttkh.getText());
           values[0]=txttkh.getText();
           Object put0=hashMap.put("tkh", values[0]);
           
           System.out.println(txtmhd.getText());
           values[1]=txtmhd.getText();
           Object put4 = hashMap.put("mhd", values[1]);
           
           System.out.println(txtdc.getText());
           values[2]=txtdc.getText();
           Object put5 = hashMap.put("dc", values[2]);
           
           System.out.println(txtsdt.getText());
           values[3]=txtsdt.getText();
           Object put6=hashMap.put("sdt", values[3]);
           
           System.out.println(txttbc.getText());
           values[4]=txttbc.getText();
           Object put7=hashMap.put("tbc", values[4]);
                   
            int [] values1;
           values1= new int[10];     
           
            System.out.println(cbongay.getSelectedItem());
            values1[0]=Integer.parseInt(cbongay.getSelectedItem().toString()) ;
            Object put1 = hashMap.put("ngay", values1[0]);
           
           System.out.println(cbothang.getSelectedItem());
           values1[1] = Integer.parseInt(cbothang.getSelectedItem().toString());
           Object put2= hashMap.put("thang",values1[1]);
           
           System.out.println(cbonam.getSelectedItem());
           values1[2] = Integer.parseInt(cbonam.getSelectedItem().toString());
           Object put3 = hashMap.put("nam",values1[2]);  
           
           System.out.println(model3.getValueAt(tblhd.getSelectedRow(),0));
           values1[3] =Integer.parseInt( model3.getValueAt(tblhd.getSelectedRow(),0).toString());
           Object put8 = hashMap.put("stt",values1[4]);
           
           System.out.println(model3.getValueAt(tblhd.getSelectedRow(),1));
           values[5]=(String)model3.getValueAt(tblhd.getSelectedRow(),1).toString();
           Object put9 = hashMap.put("tsp",values[5]);
           
           System.out.println(model3.getValueAt(tblhd.getSelectedRow(),2));
           values[6] = (String)model3.getValueAt(tblhd.getSelectedRow(),2).toString(); 
           Object put10 = hashMap.put("dvt",values[6]);
           
           long[] values2;
           values2 = new long[10];
           
           System.out.println(model3.getValueAt(tblhd.getSelectedRow(),3));
           values2[0]= Long.parseLong( model3.getValueAt(tblhd.getSelectedRow(),3).toString());
           Object put11 = hashMap.put("sl",values2[0]);
           
           System.out.println(model3.getValueAt(tblhd.getSelectedRow(),4));
           values2[1] = Long.parseLong(model3.getValueAt(tblhd.getSelectedRow(),4).toString());
           Object put12 = hashMap.put("dg",values2[1]);
           
           System.out.println(model3.getValueAt(tblhd.getSelectedRow(),5));
           values2[2] = Long.parseLong(model3.getValueAt(tblhd.getSelectedRow(),5).toString());
           Object put13 = hashMap.put("ck",values2[2]);
           
           long tongc = values2[0]*values2[1];
           values2[3] = (tongc/100)*values2[2];
           values2[4] = tongc-values2[3];
           
           Object put14 = hashMap.put("tc", tongc);
           Object put15 = hashMap.put("gg", values2[3]);
           Object put16 = hashMap.put("tt",values2[4]);
           Object put17 = hashMap.put("tst", values2[4]);
           
           
           
           
           print();
       }
    }
      public void print() {
         System.err.println(" HKT Consultant ");
        //  reportExport("/home/longnt/testA4.jasper", hashMap,tbl.getModel(),true);
        reportExport("invoices.jasper", hashMap, tbl.getModel(), false);        
    }
 private void reportExport(String filePathResource, HashMap hashMap, TableModel model, boolean flag) {
        ReportManager.getInstance().viewReport(filePathResource, hashMap, model, flag);
    }
}
