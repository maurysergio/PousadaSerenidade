
package Telas;

import Dao.ClienteDao;
import Dao.ContatoDao;
import Model.ClienteModel;
import Model.ContatoModel;
import Model.QuartoModel;
import Model.UsuarioHospedagem;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class CadastroClientes extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(CadastroClientes.class.getName());
    
    private Principal principal; //OBJETO DA TELA PRINCIPAL
    private UsuarioHospedagem usuarioLogado;
 // CRIANDO OBJETO DAO
private ClienteDao clienteDao = new ClienteDao();// OS DAOS PARA FAZER O SALVAMENTO EM TABELAS DIFERENTES
private ContatoDao contatoDao = new ContatoDao();

    public CadastroClientes(UsuarioHospedagem usuario){ // CONSTRUTOR DA TELA CLIENTE
        initComponents();
        AtualizarTabela();
        this.usuarioLogado = usuario;
        
    }
  
    private void limpar(){
        TextNome.setText("");
        TextCpf.setText("");
        TextEmail.setText("");
        TextEndereco.setText("");
    }
   private void salvar(){

    if(TextNome.getText().isEmpty() ||
       TextCpf.getText().isEmpty() ||
       TextEmail.getText().isEmpty() ||
       TextEndereco.getText().isEmpty()){

        JOptionPane.showMessageDialog(this,
            "Preencha todos os campos.");
        return;
    }

    // Cliente
    ClienteModel cliente = new ClienteModel();
    cliente.setNome(TextNome.getText());
    cliente.setCpf(TextCpf.getText());

    boolean clienteSalvo = clienteDao.salvar(cliente);

    if(clienteSalvo){

        // Contato
        ContatoModel contato = new ContatoModel();

        contato.setEmail(TextEmail.getText());

       
        contato.setTelefone(TextEndereco.getText());

        contato.setCliente(cliente);

        boolean contatoSalvo = contatoDao.salvar(contato);

        if(contatoSalvo){
            JOptionPane.showMessageDialog(
                this,
                "Cliente cadastrado com sucesso!"
            );

            limpar();
        }
    }
}
    
     private void carregarTabela(List<ClienteModel> lista) {

    DefaultTableModel model = new DefaultTableModel();

    model.addColumn("Nome");
    model.addColumn("CPF");
    model.addColumn("Email");
    model.addColumn("Telefone");

    for (ClienteModel c : lista) {

        String email = "";
String telefone = "";

if (c.getContato() != null) {
    email = c.getContato().getEmail();
    telefone = c.getContato().getTelefone();
}

model.addRow(new Object[]{
    c.getNome(),
    c.getCpf(),
    email,
    telefone
});
    }

    TableClientes.setModel(model);
}
public void AtualizarTabela() {

    ClienteDao dao = new ClienteDao();

    java.util.List<ClienteModel> lista =
            dao.listar();

    carregarTabela(lista);
}
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        TextNome = new javax.swing.JTextField();
        TextCpf = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        TextEndereco = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        TextEmail = new javax.swing.JTextField();
        ButonInicio = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableClientes = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("cadastro de clientes");
        setBackground(new java.awt.Color(133, 157, 255));
        setFont(new java.awt.Font("Calibri Light", 0, 12)); // NOI18N
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        jLabel1.setText("POUSADA SERENIDADE");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 10, -1, -1));

        TextNome.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        TextNome.setBorder(null);
        TextNome.addActionListener(this::TextNomeActionPerformed);
        getContentPane().add(TextNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 125, 190, 25));

        TextCpf.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        TextCpf.setBorder(null);
        TextCpf.addActionListener(this::TextCpfActionPerformed);
        getContentPane().add(TextCpf, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 123, 210, 25));

        jLabel4.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        jLabel4.setText("CPF");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 120, -1, -1));

        TextEndereco.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        TextEndereco.setBorder(null);
        TextEndereco.addActionListener(this::TextEnderecoActionPerformed);
        getContentPane().add(TextEndereco, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 185, 180, 25));

        jLabel2.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        jLabel2.setText("TELEFONE");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, -1, 20));

        jLabel5.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        jLabel5.setText("NOME");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        jLabel3.setText("E-MAIL");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 190, -1, 20));

        TextEmail.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        TextEmail.setBorder(null);
        TextEmail.addActionListener(this::TextEmailActionPerformed);
        getContentPane().add(TextEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 185, 190, 25));

        ButonInicio.setBackground(new java.awt.Color(106, 141, 243));
        ButonInicio.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        ButonInicio.setText("inicio");
        ButonInicio.setBorder(null);
        ButonInicio.setBorderPainted(false);
        ButonInicio.addActionListener(this::ButonInicioActionPerformed);
        getContentPane().add(ButonInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 330, 60, 30));

        jButton2.setBackground(new java.awt.Color(106, 141, 243));
        jButton2.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        jButton2.setText("CADASTRAR CLIENTE");
        jButton2.setBorder(null);
        jButton2.setBorderPainted(false);
        jButton2.addActionListener(this::jButton2ActionPerformed);
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 330, 120, 30));

        TableClientes.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(TableClientes);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 220, 680, 100));

        jLabel7.setIcon(new javax.swing.ImageIcon("C:\\Users\\maury\\OneDrive\\Documentos\\NetBeansProjects\\ProjetoIntegradorUC15\\src\\main\\java\\Telas\\IMGCAdastroCliente.png")); // NOI18N
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(-2, -4, 680, 380));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void TextNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextNomeActionPerformed

    private void TextEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextEmailActionPerformed

    private void TextCpfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextCpfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextCpfActionPerformed

    private void TextEnderecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextEnderecoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextEnderecoActionPerformed

    private void ButonInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButonInicioActionPerformed
        // TODO add your handling code here:
    Principal p = new Principal(usuarioLogado);
    p.setVisible (true);
    this.dispose();
    
    
    }//GEN-LAST:event_ButonInicioActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        salvar();
    }//GEN-LAST:event_jButton2ActionPerformed

 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButonInicio;
    private javax.swing.JTable TableClientes;
    private javax.swing.JTextField TextCpf;
    private javax.swing.JTextField TextEmail;
    private javax.swing.JTextField TextEndereco;
    private javax.swing.JTextField TextNome;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
