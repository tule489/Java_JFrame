/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package giaodien;

import Controller.Excel;
import dao.DaoChucVu;
import dao.DaoNhanVien;
import entity.ChucVu;
import entity.NhanVien;
import entity.SanPham;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Maverllous
 */
public class frmSanPham extends javax.swing.JPanel {
    Excel ex = new Excel();
    /**
     * Creates new form frmSanPham
     */
    public frmSanPham() throws SQLException, ClassNotFoundException{
        initComponents();
        LoadData2Table();
    }
    private void LoadData2Table() throws SQLException, ClassNotFoundException
    {
            List<SanPham> lstSanPham = null;
                // Lấy danh sách sản phẩm
            switch (cboLoc.getSelectedIndex()) {
                case 1: {
                    lstSanPham = dao.DaoSanPham.getOneSP(cboLoc.getSelectedItem().toString());
                    break;
                }
                case 2: {
                    lstSanPham = dao.DaoSanPham.getOneSP(cboLoc.getSelectedItem().toString());
                    break;
                }
                case 0: {
                    lstSanPham = dao.DaoSanPham.getAllSP();
                    break;
                }
            }
            //--- Thêm các tiêu đề cho cột của bảng hiển thị
            DefaultTableModel tblModel = new DefaultTableModel();
            tblModel.addColumn("Mã sản phẩm");
            tblModel.addColumn("Tên sản phẩm");
            tblModel.addColumn("Loại");
            tblModel.addColumn("Số lượng");
            tblModel.addColumn("Giá");
            //--- add lần lượt các row
            for (SanPham _sanpham : lstSanPham) {
                Vector<String> row = new Vector<String>();
                row.addElement(String.valueOf(_sanpham.getMasp()));
                row.addElement(_sanpham.getTensp());
                row.addElement(_sanpham.getLoai());
                row.addElement(String.valueOf(_sanpham.getSoluong()));
                row.addElement(String.valueOf(_sanpham.getGia()));
                tblModel.addRow(row); 
            }
            tableSanPham.setModel(tblModel);
    }
    
    private void LoadData2Control() throws SQLException, ClassNotFoundException, ParseException
    {
        if (tableSanPham.getSelectedRow() != -1) {
            //-- Xác định hàng đã click
            int i = tableSanPham.getSelectedRow();
            
            //-- Lấy được danh sách sản phẩm
            List<SanPham> lstSanPham=null;
            if(!"".equals(txtFind.getText()))
                lstSanPham =dao.DaoSanPham.getFind(txtFind.getText());
            else
            {
                switch (cboLoc.getSelectedItem().toString()) {
                case "ALL": lstSanPham = dao.DaoSanPham.getAllSP();
                case "Đồ ăn": lstSanPham = dao.DaoSanPham.getOneSP(cboLoc.getSelectedItem().toString());
                case "Đồ uống": lstSanPham = dao.DaoSanPham.getOneSP(cboLoc.getSelectedItem().toString());
                }
            }   
            SanPham sp1 = lstSanPham.get(i);
            //--- Set giá trị cho các control
            txtMasanpham.setText(String.valueOf(sp1.getMasp()));
            txtTensanpham.setText(sp1.getTensp());
            txtLoai.setText(sp1.getLoai());
            txtSoluong.setText(String.valueOf(sp1.getSoluong()));
            txtGia.setText(String.valueOf(sp1.getGia()));
            txtGianhap.setText(String.valueOf(sp1.getGianhap()));
            txtNgay.setText(sp1.getNgay());
        }
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator1 = new javax.swing.JSeparator();
        jButton5 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableSanPham = new org.jdesktop.swingx.JXTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtMasanpham = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtTensanpham = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtLoai = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtSoluong = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtGia = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtGianhap = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtNgay = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        btnTimkiem = new javax.swing.JButton();
        txtFind = new javax.swing.JTextField();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        cboLoc = new javax.swing.JComboBox<>();
        btnReset = new javax.swing.JButton();
        btnXuatEX = new javax.swing.JButton();

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/thoat.png"))); // NOI18N
        jButton5.setText("Thoát");
        jButton5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton5MouseClicked(evt);
            }
        });
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Danh sách sản phẩm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        tableSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tableSanPham);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin sản phẩm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        jLabel1.setText("Mã sản phẩm");

        jLabel2.setText("Tên sản phẩm");

        jLabel3.setText("Loại");

        jLabel4.setText("Số lượng");

        txtSoluong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSoluongActionPerformed(evt);
            }
        });

        jLabel5.setText("Giá bán");

        txtGia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGiaActionPerformed(evt);
            }
        });

        jLabel6.setText("Giá nhập");

        jLabel7.setText("Ngày nhập");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtMasanpham, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtLoai)
                            .addComponent(txtTensanpham))))
                .addGap(60, 60, 60)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNgay))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtGia)
                            .addComponent(txtGianhap)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSoluong)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtMasanpham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txtSoluong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtTensanpham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(txtGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtLoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(txtGianhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtNgay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Chức năng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        btnTimkiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/timkiem.png"))); // NOI18N
        btnTimkiem.setText("Tìm kiếm");
        btnTimkiem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTimkiemMouseClicked(evt);
            }
        });

        txtFind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFindActionPerformed(evt);
            }
        });

        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/them.png"))); // NOI18N
        btnThem.setText("Thêm");
        btnThem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnThemMouseClicked(evt);
            }
        });

        btnSua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/sua.png"))); // NOI18N
        btnSua.setText("Sửa");
        btnSua.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSuaMouseClicked(evt);
            }
        });

        btnXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/xoa.png"))); // NOI18N
        btnXoa.setText("Xóa");
        btnXoa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnXoaMouseClicked(evt);
            }
        });
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        cboLoc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ALL", "Đồ ăn", "Đồ uống" }));
        cboLoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboLocActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnThem)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSua)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnXoa)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cboLoc, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addComponent(txtFind, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnTimkiem)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(cboLoc)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnTimkiem)
                        .addComponent(btnThem)
                        .addComponent(btnSua)
                        .addComponent(txtFind))
                    .addComponent(btnXoa, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnReset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/reset.png"))); // NOI18N
        btnReset.setText("reset");
        btnReset.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnResetMouseClicked(evt);
            }
        });

        btnXuatEX.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/xuatex.png"))); // NOI18N
        btnXuatEX.setText("Xuất Excel");
        btnXuatEX.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnXuatEXMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnReset)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnXuatEX)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton5))
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton5)
                    .addComponent(btnReset)
                    .addComponent(btnXuatEX, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtFindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFindActionPerformed
        // TODO add your handling code here:
        List<SanPham> lstSanPham = null;
        try {
            lstSanPham = dao.DaoSanPham.getFind(txtFind.getText());
        } catch (SQLException ex) {
            Logger.getLogger(frmSanPham.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(frmSanPham.class.getName()).log(Level.SEVERE, null, ex);
        }
        //--- Thêm các tiêu đề cho cột của bảng hiển thị
            DefaultTableModel tblModel = new DefaultTableModel();
            tblModel.addColumn("Mã sản phẩm");
            tblModel.addColumn("Tên sản phẩm");
            tblModel.addColumn("Loại");
            tblModel.addColumn("Số lượng");
            tblModel.addColumn("Giá bán");
            tblModel.addColumn("Giá nhập");
            tblModel.addColumn("Ngày nhập");
            //--- add lần lượt các row
            for (SanPham _sanpham : lstSanPham) {
                Vector<String> row = new Vector<String>();
                row.addElement(String.valueOf(_sanpham.getMasp()));
                row.addElement(_sanpham.getTensp());
                row.addElement(_sanpham.getLoai());
                row.addElement(String.valueOf(_sanpham.getSoluong()));
                row.addElement(String.valueOf(_sanpham.getGia()));
                row.addElement(String.valueOf(_sanpham.getGianhap()));
                row.addElement(_sanpham.getNgay());
                tblModel.addRow(row); 
            }
            tableSanPham.setModel(tblModel);
    }//GEN-LAST:event_txtFindActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnXoaActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton5MouseClicked
        // TODO add your handling code here:
        int dialogButton = JOptionPane.showConfirmDialog (null, "Bạn muốn thoát chương trình?","WARNING", JOptionPane.YES_NO_OPTION);
        if(dialogButton == JOptionPane.YES_OPTION) 
        {
            try {
                // TODO add your handling code here:
                dao.DaoNguoiDungDangNhap.DeleteNDDN();
            } catch (SQLException | ClassNotFoundException ex) {
                JOptionPane.showMessageDialog(this, ex);
                Logger.getLogger(frmSanPham.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.exit(0);
        }
        else
            remove(dialogButton);             
    }//GEN-LAST:event_jButton5MouseClicked

    private void btnThemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnThemMouseClicked
        // TODO add your handling code here:
        SanPham _sanpham = new SanPham();
        _sanpham.setMasp(Integer.valueOf(txtMasanpham.getText()));
        _sanpham.setTensp(txtTensanpham.getText());
        _sanpham.setLoai(txtLoai.getText());
        _sanpham.setSoluong(Integer.valueOf(txtSoluong.getText()));
        _sanpham.setGia(Float.valueOf(txtGia.getText()));
        _sanpham.setGianhap(Float.valueOf(txtGianhap.getText()));
        _sanpham.setNgay(txtNgay.getText());
        try {
            dao.DaoSanPham.InsertSP(_sanpham);
            LoadData2Table();
            JOptionPane.showMessageDialog(this, "Thêm mới thành công!");
        } catch (SQLException | ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(this, ex);
            Logger.getLogger(frmNhanVien.class.getName()).log(Level.SEVERE, null, ex);
        }
        txtMasanpham.setText("");
        txtTensanpham.setText("");
        txtLoai.setText("");
        txtSoluong.setText("");
        txtGia.setText("");    
        txtGianhap.setText("");
        txtNgay.setText("");        
    }//GEN-LAST:event_btnThemMouseClicked

    private void txtGiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGiaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGiaActionPerformed

    private void tableSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableSanPhamMouseClicked
        // TODO add your handling code here:
        try {
            try {
                // TODO add your handling code here:
                LoadData2Control();
            } catch (ParseException ex) {
                Logger.getLogger(frmSanPham.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(frmSanPham.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_tableSanPhamMouseClicked

    private void btnSuaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSuaMouseClicked
        // TODO add your handling code here:
        SanPham _sanpham = new SanPham();
        _sanpham.setMasp(Integer.valueOf(txtMasanpham.getText()));
        _sanpham.setTensp(txtTensanpham.getText());
        _sanpham.setLoai(txtLoai.getText());
        _sanpham.setSoluong(Integer.valueOf(txtSoluong.getText()));
        _sanpham.setGia(Float.valueOf(txtGia.getText()));
        _sanpham.setGianhap(Float.valueOf(txtGianhap.getText()));
        _sanpham.setNgay(txtNgay.getText());
        try {
            dao.DaoSanPham.UpdateSP(_sanpham);
            LoadData2Table();
            JOptionPane.showMessageDialog(this, "Sửa thành công!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex);
            Logger.getLogger(frmSanPham.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(this, ex);
        }
    }//GEN-LAST:event_btnSuaMouseClicked

    private void btnXoaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnXoaMouseClicked
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            dao.DaoSanPham.DeleteSP(txtMasanpham.getText());
            LoadData2Table();
            JOptionPane.showMessageDialog(this, "Xóa thành công!");
        } catch (SQLException | ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(this, ex);
            Logger.getLogger(frmSanPham.class.getName()).log(Level.SEVERE, null, ex);
        }
        txtMasanpham.setText("");
        txtTensanpham.setText("");
        txtLoai.setText("");
        txtSoluong.setText("");
        txtGia.setText("");    
        txtGianhap.setText("");
        txtNgay.setText("");        
    }//GEN-LAST:event_btnXoaMouseClicked

    private void cboLocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboLocActionPerformed
        try {
            // TODO add your handling code here:
            LoadData2Table();
        } catch (SQLException ex) {
            Logger.getLogger(frmSanPham.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(frmSanPham.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cboLocActionPerformed

    private void btnTimkiemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTimkiemMouseClicked
        // TODO add your handling code here:
        List<SanPham> lstSanPham = null;
        try {
            lstSanPham = dao.DaoSanPham.getFind(txtFind.getText());
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(frmSanPham.class.getName()).log(Level.SEVERE, null, ex);
        }
        //--- Thêm các tiêu đề cho cột của bảng hiển thị
            DefaultTableModel tblModel = new DefaultTableModel();
            tblModel.addColumn("Mã sản phẩm");
            tblModel.addColumn("Tên sản phẩm");
            tblModel.addColumn("Loại");
            tblModel.addColumn("Số lượng");
            tblModel.addColumn("Giá bán");
            tblModel.addColumn("Giá nhập");
            tblModel.addColumn("Ngày nhập");
            //--- add lần lượt các row
            for (SanPham _sanpham : lstSanPham) {
                Vector<String> row = new Vector<String>();
                row.addElement(String.valueOf(_sanpham.getMasp()));
                row.addElement(_sanpham.getTensp());
                row.addElement(_sanpham.getLoai());
                row.addElement(String.valueOf(_sanpham.getSoluong()));
                row.addElement(String.valueOf(_sanpham.getGia()));
                row.addElement(String.valueOf(_sanpham.getGianhap()));
                row.addElement(_sanpham.getNgay());
                tblModel.addRow(row); 
            }
            tableSanPham.setModel(tblModel);
    }//GEN-LAST:event_btnTimkiemMouseClicked

    private void txtSoluongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSoluongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSoluongActionPerformed

    private void btnResetMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnResetMouseClicked
        // TODO add your handling code here:
        txtMasanpham.setText("");
        txtTensanpham.setText("");
        txtGia.setText("");
        txtGianhap.setText("");
        txtLoai.setText("");
        txtSoluong.setText("");
        txtFind.setText("");
        txtNgay.setText("");
        cboLoc.setSelectedIndex(0);
        try {
            LoadData2Table();
        } catch (SQLException ex) {
            Logger.getLogger(frmSanPham.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(frmSanPham.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnResetMouseClicked

    private void btnXuatEXMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnXuatEXMouseClicked
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            ex.WriteExcel("SP", "SanPham");
        } catch (Exception ex) {
            Logger.getLogger(frmNhanVien.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnXuatEXMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnTimkiem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JButton btnXuatEX;
    private javax.swing.JComboBox<String> cboLoc;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private org.jdesktop.swingx.JXTable tableSanPham;
    private javax.swing.JTextField txtFind;
    private javax.swing.JTextField txtGia;
    private javax.swing.JTextField txtGianhap;
    private javax.swing.JTextField txtLoai;
    private javax.swing.JTextField txtMasanpham;
    private javax.swing.JTextField txtNgay;
    private javax.swing.JTextField txtSoluong;
    private javax.swing.JTextField txtTensanpham;
    // End of variables declaration//GEN-END:variables

}
