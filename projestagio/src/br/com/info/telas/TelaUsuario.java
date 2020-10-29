package br.com.info.telas;

import java.sql.*;
import br.com.info.dal.ModuloConexão;
import javax.swing.JOptionPane;

public class TelaUsuario extends javax.swing.JInternalFrame {

    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    public TelaUsuario() {
        initComponents();
        conexao = ModuloConexão.conector();
    }

    private void consultar() {
        String sql = "select * from tbusuarios where id = ?";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtId.getText());
            rs = pst.executeQuery();
            if (rs.next()) {
                txtnome.setText(rs.getString(2));
                txtusuario.setText(rs.getString(4));
                txtsenha.setText(rs.getString(5));
                txttelefone.setText(rs.getString(3));
                txtendereco.setText(rs.getString(7));
                txtcpf.setText(rs.getString(6));
            } else {
                JOptionPane.showMessageDialog(null, "Usuário não cadastrado");
                txtnome.setText(null);
                txtusuario.setText(null);
                txtsenha.setText(null);
                txttelefone.setText(null);
                txtendereco.setText(null);
                txtcpf.setText(null);

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    private void adicionar() {
        String sql = "insert into tbusuarios(usuario, telefone, login, senha, cpf, endereco, perfil) values(?,?,?,?,?,?,?)";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtnome.getText());
            pst.setString(2, txttelefone.getText());
            pst.setString(3, txtusuario.getText());
            pst.setString(4, txtsenha.getText());
            pst.setString(5, txtcpf.getText());
            pst.setString(6, txtendereco.getText());
            pst.setString(7, "user");

            if (txtnome.getText().isEmpty() || txtusuario.getText().isEmpty() || txtsenha.getText().isEmpty() || txtcpf.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigatórios");
            } else {
                pst.executeUpdate();
                JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso");
                txtnome.setText(null);
                txtusuario.setText(null);
                txtsenha.setText(null);
                txttelefone.setText(null);
                txtendereco.setText(null);
                txtcpf.setText(null);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    private void alterar() {
        String sql = "update tbusuarios set login = ?, senha = ?, telefone = ?, endereco = ? where id = ?";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtusuario.getText());
            pst.setString(2, txtsenha.getText());
            pst.setString(3, txttelefone.getText());
            pst.setString(4, txtendereco.getText());
            pst.setString(5, txtId.getText());
            
            if (txtnome.getText().isEmpty() || txtusuario.getText().isEmpty() || txtsenha.getText().isEmpty() || txtcpf.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigatórios");
            } else {
                pst.executeUpdate();
                JOptionPane.showMessageDialog(null, "Dados alterados com sucesso");
                txtnome.setText(null);
                txtusuario.setText(null);
                txtsenha.setText(null);
                txttelefone.setText(null);
                txtendereco.setText(null);
                txtcpf.setText(null);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }
    private void remover(){
        int confirma = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja remover esse usuário?", "Confirmar remoção", JOptionPane.YES_NO_OPTION);
        if(confirma == JOptionPane.YES_OPTION){
            String sql = "delete from tbusuarios where id = ?";
            try {
                pst = conexao.prepareStatement(sql);
                pst.setString(1, txtId.getText());
                pst.executeUpdate();
                JOptionPane.showMessageDialog(null, "Usuário removido com sucesso");
                txtnome.setText(null);
                txtusuario.setText(null);
                txtsenha.setText(null);
                txttelefone.setText(null);
                txtendereco.setText(null);
                txtcpf.setText(null);
                               
                
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtnome = new javax.swing.JTextField();
        txtusuario = new javax.swing.JTextField();
        txtsenha = new javax.swing.JPasswordField();
        txttelefone = new javax.swing.JTextField();
        txtendereco = new javax.swing.JTextField();
        txtcpf = new javax.swing.JTextField();
        btnAdicionar = new javax.swing.JButton();
        btnConsultar = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        btnApagar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Usuários");

        jLabel1.setText("Nome*");

        jLabel2.setText("Telefone");

        jLabel3.setText("Endereco");

        jLabel4.setText("CPF*");

        jLabel5.setText("Usuário*");

        jLabel6.setText("Senha*");

        txtnome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnomeActionPerformed(evt);
            }
        });

        btnAdicionar.setText("Adicionar");
        btnAdicionar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarActionPerformed(evt);
            }
        });

        btnConsultar.setText("Consultar");
        btnConsultar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarActionPerformed(evt);
            }
        });

        btnAlterar.setText("Alterar");
        btnAlterar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });

        btnApagar.setText("Apagar");
        btnApagar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnApagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnApagarActionPerformed(evt);
            }
        });

        jLabel7.setText("ID");

        jLabel8.setText("* Campos obrigatórios");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel3)
                        .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txttelefone)
                    .addComponent(txtendereco)
                    .addComponent(txtcpf)
                    .addComponent(txtusuario)
                    .addComponent(txtsenha)
                    .addComponent(txtnome)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAdicionar)
                        .addGap(18, 18, 18)
                        .addComponent(btnAlterar)
                        .addGap(18, 18, 18)
                        .addComponent(btnApagar)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnConsultar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 148, Short.MAX_VALUE)
                        .addComponent(jLabel8)))
                .addGap(51, 51, 51))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtnome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtusuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtsenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txttelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtendereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtcpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdicionar)
                    .addComponent(btnAlterar)
                    .addComponent(btnApagar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnConsultar)
                    .addComponent(jLabel7)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(61, 61, 61))
        );

        setBounds(0, 0, 600, 450);
    }// </editor-fold>//GEN-END:initComponents

    private void txtnomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnomeActionPerformed

    private void btnConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarActionPerformed
        consultar();
    }//GEN-LAST:event_btnConsultarActionPerformed

    private void btnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarActionPerformed
        adicionar();
    }//GEN-LAST:event_btnAdicionarActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        alterar();
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void btnApagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnApagarActionPerformed
        remover();
    }//GEN-LAST:event_btnApagarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionar;
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnApagar;
    private javax.swing.JButton btnConsultar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtcpf;
    private javax.swing.JTextField txtendereco;
    private javax.swing.JTextField txtnome;
    private javax.swing.JPasswordField txtsenha;
    private javax.swing.JTextField txttelefone;
    private javax.swing.JTextField txtusuario;
    // End of variables declaration//GEN-END:variables
}
