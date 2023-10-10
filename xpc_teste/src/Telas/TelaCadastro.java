/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package Telas;

import java.awt.Image;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

/**
 *
 * @author Gabriel
 */
public class TelaCadastro extends javax.swing.JInternalFrame {
public String cpf,dtnasc,dtval,dtorg;
    /**
     * Creates new form TelaCadastro
     */
    public TelaCadastro() {
        initComponents();
       txtcampos.setVisible(false);
       SimpleAttributeSet attributes = new SimpleAttributeSet();
        StyleConstants.setAlignment(attributes, StyleConstants.ALIGN_LEFT);
        StyleConstants.setLineSpacing(attributes, 1.0f);
        StyleConstants.setLeftIndent(attributes, 10.0f);
        StyleConstants.setRightIndent(attributes, 10.0f);
        StyleConstants.setFirstLineIndent(attributes, 10.0f);
        txtreferencia.setParagraphAttributes(attributes, true);
    }
    
    public void Upls_ler() throws IOException {
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            String caminhoImagem = selectedFile.getAbsolutePath();
            processarImagem(caminhoImagem);
            
            Image foto = ImageIO.read(fileChooser.getSelectedFile()).getScaledInstance(arqfoto.getWidth(), arqfoto.getHeight(), Image.SCALE_SMOOTH);
            arqfoto.setIcon(new ImageIcon(foto));
            iso();
        }
    }

    private void processarImagem(String caminhoImagem) {
        // Restante do seu código para processar a imagem aqui
        // ...
        String caminhoScriptPython = "C:\\Users\\Samsung\\Documents\\NetBeansProjects\\Projeto_OCR\\REC\\rec.py";
        ProcessBuilder processBuilder = new ProcessBuilder("python", caminhoScriptPython, caminhoImagem);

        // Configura as variáveis de ambiente, incluindo o caminho para o Tesseract-OCR
        Map<String, String> env = processBuilder.environment();
        env.put("PATH", "C:\\caminho\\para\\Tesseract-OCR");  // Substitua pelo caminho real para o Tesseract-OCR

        processBuilder.redirectErrorStream(true);

        try {
            // Adicione um pequeno atraso antes de executar o pytesseract (1 segundo)
            Thread.sleep(5000);

            Process process = processBuilder.start();

            // Obtém o InputStream do processo Python
            InputStream inputStream = process.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            // Lê a saída do processo Python linha por linha
            StringBuilder output = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                output.append(line).append("\n");
            }

            // Agora, 'output' contém a saída completa do processo Python
            String texto_corrigido = output.toString();
            System.out.println("Saída do Python:");
            txtcampos.setText(texto_corrigido);

            // Certifique-se de esperar o término do processo antes de prosseguir com o código Java
            process.waitFor();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
//isola os campos da identidade e joga para o sistema poder acessar em qualquer tela
    private void iso() {
        String isolar_texto_cpf = txtcampos.getText();
        String isolar_texto_nasc = txtcampos.getText();
        String isolar_texto_val = txtcampos.getText();
        String isolar_texto_orgn = txtcampos.getText();
        
        isolar_texto_cpf = isolar_texto_cpf.substring(0, isolar_texto_cpf.length()-87);
        isolar_texto_nasc = isolar_texto_nasc.substring(31, isolar_texto_nasc.length()-57 );
        isolar_texto_val = isolar_texto_val.substring(62, isolar_texto_val.length()-27 );
        isolar_texto_orgn = isolar_texto_orgn.substring(92, isolar_texto_orgn.length()-1 );
//        System.out.println(isolar_texto_cpf);
//        System.out.println(isolar_texto_nasc);
//        System.out.println(isolar_texto_val);
//        System.out.println(isolar_texto_orgn);
        cpf=isolar_texto_cpf;
        dtnasc= isolar_texto_nasc;
        dtval=isolar_texto_val;
        dtorg=isolar_texto_orgn;    
        
        
    }
    
    private void preencher_dados_rg(){
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        arqfoto = new javax.swing.JLabel();
        tnt = new javax.swing.JButton();
        txtcod = new javax.swing.JTextField();
        txtendereco = new javax.swing.JTextField();
        txtemail = new javax.swing.JTextField();
        txtcnpj = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtbairro = new javax.swing.JTextField();
        txtcpf = new javax.swing.JTextField();
        txtcod_la = new javax.swing.JLabel();
        txttel = new javax.swing.JTextField();
        txtn = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtnome = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtcampos = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        cbosexo = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        txtdata = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtnomepai = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtprof = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        txtrg = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        cboestadoci = new javax.swing.JComboBox<>();
        jLabel19 = new javax.swing.JLabel();
        txtnomemae = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel21 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        txtcep = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        txtlogradouro = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtreferencia = new javax.swing.JTextPane();
        cbouf = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        txtcomplemento = new javax.swing.JTextField();
        txtnum = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        cbocidade = new javax.swing.JComboBox<>();
        btncadastrar = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();

        setBackground(new java.awt.Color(204, 204, 204));
        setClosable(true);
        setForeground(new java.awt.Color(204, 204, 204));
        setIconifiable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/WhatsApp_Image_2023-10-03_at_18.30.00-removebg-preview.png"))); // NOI18N
        jLabel1.setOpaque(true);
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -170, 520, 1360));

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setLayout(null);

        arqfoto.setBackground(new java.awt.Color(204, 204, 204));
        arqfoto.setForeground(new java.awt.Color(255, 255, 255));
        arqfoto.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        arqfoto.setOpaque(true);
        jPanel1.add(arqfoto);
        arqfoto.setBounds(64, 27, 693, 281);

        tnt.setText("Upload/identidade");
        tnt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tntActionPerformed(evt);
            }
        });
        jPanel1.add(tnt);
        tnt.setBounds(361, 326, 138, 23);
        jPanel1.add(txtcod);
        txtcod.setBounds(411, 1682, 162, 23);
        jPanel1.add(txtendereco);
        txtendereco.setBounds(85, 1682, 250, 23);
        jPanel1.add(txtemail);
        txtemail.setBounds(555, 570, 250, 23);
        jPanel1.add(txtcnpj);
        txtcnpj.setBounds(555, 528, 250, 23);

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("CPF");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(481, 432, 24, 17);
        jPanel1.add(txtbairro);
        txtbairro.setBounds(70, 940, 250, 23);
        jPanel1.add(txtcpf);
        txtcpf.setBounds(558, 429, 250, 23);

        txtcod_la.setBackground(new java.awt.Color(255, 255, 255));
        txtcod_la.setForeground(new java.awt.Color(255, 255, 255));
        txtcod_la.setText("COD");
        jPanel1.add(txtcod_la);
        txtcod_la.setBounds(341, 1685, 28, 17);
        jPanel1.add(txttel);
        txttel.setBounds(110, 630, 250, 23);
        jPanel1.add(txtn);
        txtn.setBounds(121, 1705, 250, 23);

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Email");
        jPanel1.add(jLabel11);
        jLabel11.setBounds(482, 573, 32, 17);

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Bairro");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(10, 940, 34, 17);
        jPanel1.add(txtnome);
        txtnome.setBounds(117, 475, 250, 23);

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("CNPJ");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(481, 531, 33, 17);

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("UF");
        jPanel1.add(jLabel10);
        jLabel10.setBounds(10, 1000, 16, 17);

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Tipo");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(10, 429, 25, 17);

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Nome");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(8, 472, 34, 17);

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Nº");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(12, 1708, 14, 17);

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Telefone");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(10, 630, 49, 17);

        txtcampos.setText("jTextField12");
        jPanel1.add(txtcampos);
        txtcampos.setBounds(739, 830, 85, 23);

        jLabel12.setBackground(new java.awt.Color(255, 255, 255));
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Sexo");
        jPanel1.add(jLabel12);
        jLabel12.setBounds(8, 518, 29, 17);

        cbosexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "(Não informado)", "Masculino", "Feminino" }));
        jPanel1.add(cbosexo);
        cbosexo.setBounds(117, 515, 142, 23);

        jLabel13.setBackground(new java.awt.Color(255, 255, 255));
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Data de Nascimento");
        jPanel1.add(jLabel13);
        jLabel13.setBounds(8, 573, 119, 17);

        txtdata.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtdataActionPerformed(evt);
            }
        });
        jPanel1.add(txtdata);
        txtdata.setBounds(155, 570, 182, 23);

        jLabel14.setBackground(new java.awt.Color(255, 255, 255));
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Nome do pai");
        jPanel1.add(jLabel14);
        jLabel14.setBounds(480, 680, 75, 17);

        txtnomepai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnomepaiActionPerformed(evt);
            }
        });
        jPanel1.add(txtnomepai);
        txtnomepai.setBounds(580, 680, 226, 23);

        jLabel15.setBackground(new java.awt.Color(255, 255, 255));
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Profissão");
        jPanel1.add(jLabel15);
        jLabel15.setBounds(10, 680, 54, 17);

        txtprof.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtprofActionPerformed(evt);
            }
        });
        jPanel1.add(txtprof);
        txtprof.setBounds(80, 680, 247, 23);

        jLabel16.setFont(new java.awt.Font("Helvetica Neue", 0, 10)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("(DDD+ Número)");
        jPanel1.add(jLabel16);
        jLabel16.setBounds(380, 630, 72, 13);

        jLabel17.setBackground(new java.awt.Color(255, 255, 255));
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("RG");
        jPanel1.add(jLabel17);
        jLabel17.setBounds(484, 478, 19, 17);
        jPanel1.add(txtrg);
        txtrg.setBounds(558, 478, 250, 23);

        jLabel18.setBackground(new java.awt.Color(255, 255, 255));
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Estado civil");
        jPanel1.add(jLabel18);
        jLabel18.setBounds(480, 740, 68, 17);

        cboestadoci.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "(Não informado)", "Solteiro (a)", "Casado (a)", "Deparado (a)", "Divorciado (a)", "Viúvo (a)" }));
        jPanel1.add(cboestadoci);
        cboestadoci.setBounds(570, 740, 139, 23);

        jLabel19.setBackground(new java.awt.Color(255, 255, 255));
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Nome da mãe");
        jPanel1.add(jLabel19);
        jLabel19.setBounds(482, 628, 82, 17);

        txtnomemae.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnomemaeActionPerformed(evt);
            }
        });
        jPanel1.add(txtnomemae);
        txtnomemae.setBounds(582, 625, 226, 23);

        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Dados Pessoais");
        jPanel1.add(jLabel20);
        jLabel20.setBounds(8, 384, 95, 17);
        jPanel1.add(jSeparator1);
        jSeparator1.setBounds(14, 407, 799, 10);

        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Endereço");
        jPanel1.add(jLabel21);
        jLabel21.setBounds(8, 791, 55, 17);
        jPanel1.add(jSeparator2);
        jSeparator2.setBounds(14, 814, 799, 10);

        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Endereço");
        jPanel1.add(jLabel22);
        jLabel22.setBounds(12, 1685, 55, 17);

        jLabel23.setBackground(new java.awt.Color(255, 255, 255));
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("CEP");
        jPanel1.add(jLabel23);
        jLabel23.setBounds(10, 840, 25, 17);
        jPanel1.add(txtcep);
        txtcep.setBounds(70, 840, 250, 23);

        jLabel24.setBackground(new java.awt.Color(255, 255, 255));
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("Logradouro");
        jPanel1.add(jLabel24);
        jLabel24.setBounds(10, 890, 65, 17);
        jPanel1.add(txtlogradouro);
        txtlogradouro.setBounds(100, 890, 220, 23);

        jLabel25.setBackground(new java.awt.Color(255, 255, 255));
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("Referência");
        jPanel1.add(jLabel25);
        jLabel25.setBounds(10, 1060, 62, 17);

        jScrollPane2.setViewportView(txtreferencia);

        jPanel1.add(jScrollPane2);
        jScrollPane2.setBounds(80, 1060, 250, 110);

        cbouf.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pernambuco" }));
        jPanel1.add(cbouf);
        cbouf.setBounds(70, 1000, 180, 23);

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Cidade");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(550, 980, 50, 17);

        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("Número");
        jPanel1.add(jLabel26);
        jLabel26.setBounds(550, 880, 50, 17);
        jPanel1.add(txtcomplemento);
        txtcomplemento.setBounds(640, 920, 64, 23);

        txtnum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnumActionPerformed(evt);
            }
        });
        jPanel1.add(txtnum);
        txtnum.setBounds(610, 880, 64, 23);

        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setText("Complemento");
        jPanel1.add(jLabel27);
        jLabel27.setBounds(550, 920, 90, 17);

        cbocidade.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Abreu e Lima ", "Afogados da Ingazeira ", "Afrânio Agrestina ", "Água Preta ", "Águas Belas ", "Alagoinha ", "Aliança ", "Altinho ", "Amaraji ", "Angelim ", "Araçoiaba ", "Araripina ", "Arcoverde", "Barra de Guabiraba ", "Barreiros ", "Belém de Maria ", "Belém do São Francisco ", "Belo Jardim Betânia ", "Bezerros Bodocó ", "Bom Conselho ", "Bom Jardim ", "Bonito ", "Brejão ", "Brejinho ", "Brejo da Madre de Deus ", "Buenos Aires ", "Buíque", " ", "Cabo de Santo Agostinho", "Cabrobó ", "Cachoeirinha ", "Caetés ", "Calçado ", "Calumbi ", "Camaragibe ", "Camocim de São Félix ", "Camutanga ", "Canhotinho ", "Capoeiras ", "Carnaíba ", "Carnaubeira da Penha ", "Carpina ", "Caruaru ", "Casinhas ", "Catende ", "Cedro ", "Chã de Alegria ", "Chã Grande ", "Condado ", "Correntes ", "Cortês ", "Cumaru ", "Cupira ", "Custódia" }));
        jPanel1.add(cbocidade);
        cbocidade.setBounds(620, 980, 150, 23);

        btncadastrar.setText("Cadastrar");
        jPanel1.add(btncadastrar);
        btncadastrar.setBounds(590, 1130, 100, 30);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(jComboBox1);
        jComboBox1.setBounds(130, 430, 140, 23);

        jScrollPane1.setViewportView(jPanel1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 0, 860, 1260));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtnomemaeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnomemaeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnomemaeActionPerformed

    private void txtprofActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtprofActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtprofActionPerformed

    private void txtnomepaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnomepaiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnomepaiActionPerformed

    private void txtdataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdataActionPerformed

    }//GEN-LAST:event_txtdataActionPerformed

    private void tntActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tntActionPerformed
        try {
            // TODO add your handling code here:
            Upls_ler();
        } catch (IOException ex) {
            Logger.getLogger(TelaCadastro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_tntActionPerformed

    private void txtnumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnumActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnumActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel arqfoto;
    private javax.swing.JButton btncadastrar;
    private javax.swing.JComboBox<String> cbocidade;
    private javax.swing.JComboBox<String> cboestadoci;
    private javax.swing.JComboBox<String> cbosexo;
    private javax.swing.JComboBox<String> cbouf;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JButton tnt;
    private javax.swing.JTextField txtbairro;
    private javax.swing.JTextField txtcampos;
    private javax.swing.JTextField txtcep;
    private javax.swing.JTextField txtcnpj;
    private javax.swing.JTextField txtcod;
    private javax.swing.JLabel txtcod_la;
    private javax.swing.JTextField txtcomplemento;
    private javax.swing.JTextField txtcpf;
    private javax.swing.JTextField txtdata;
    private javax.swing.JTextField txtemail;
    private javax.swing.JTextField txtendereco;
    private javax.swing.JTextField txtlogradouro;
    private javax.swing.JTextField txtn;
    private javax.swing.JTextField txtnome;
    private javax.swing.JTextField txtnomemae;
    private javax.swing.JTextField txtnomepai;
    private javax.swing.JTextField txtnum;
    private javax.swing.JTextField txtprof;
    private javax.swing.JTextPane txtreferencia;
    private javax.swing.JTextField txtrg;
    private javax.swing.JTextField txttel;
    // End of variables declaration//GEN-END:variables
}
