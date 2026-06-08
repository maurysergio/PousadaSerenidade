
package Telas;


import Dao.CategoriaQuartoDao;
import Dao.QuartoDao;
import Model.CategoriaQuartoModel;
import Model.QuartoModel;
import Model.UsuarioHospedagem;
import javax.swing.JOptionPane;

public class TelaCadastroQuarto extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(TelaCadastroQuarto.class.getName());
    
private Principal principal; 
     public QuartoDao dao = new QuartoDao(); //CRIANDO OBJETO DAO
     private UsuarioHospedagem usuarioLogado;
    public TelaCadastroQuarto( UsuarioHospedagem usuario) {
        initComponents();
        this.usuarioLogado = usuario;
        AtualizarTabela();
        carregarCategorias();
       
        
       
        
    }
    
     private void limpar(){
     TextNumero.setText("");
    
     }
     
     private void carregarCategorias() {

    CategoriaQuartoDao dao = new CategoriaQuartoDao();

    for (CategoriaQuartoModel c : dao.listar()) {
        ComboCategoria.removeAllItems();
    }
}
     
     private void carregarTabela(java.util.List<QuartoModel> lista) {

        javax.swing.table.DefaultTableModel model = new javax.swing.table.DefaultTableModel();

        model.addColumn("ID");
        model.addColumn("QUARTO");
        model.addColumn("TIPO");
        model.addColumn("VALOR");
       
        

        for (QuartoModel c : lista) {
            model.addRow(new Object[]{
                c.getIdQuarto(),
                c.getNumero(),
               c.getCategoria().getCategoria(),
               c.getCategoria().getValor()
               
            });
        }

        TableQuarto.setModel(model);
    }
     
    private void salvar(){
     
     QuartoModel  q = new QuartoModel ();// CRIANDO UM OBJETO VAZIO 
      
        
    try{
        q.setNumero(Integer.parseInt(TextNumero.getText())); //pegando  u numero do quarto
}
    catch(NumberFormatException e){
    JOptionPane.showMessageDialog(this,
        "Digite apenas números.");
    return;
}

      
      
      CategoriaQuartoModel categoria = //pegando o dado selecionado pelo usuario
    (CategoriaQuartoModel) ComboCategoria.getSelectedItem();
      q.setCategoria(categoria);
     
     
     
      
      /*compo de validaçao, para que nao ocorra o cadastro de canpos vazios*/
      
      if (TextNumero.getText().trim().isEmpty()) { // aqui o trim nao deixa salvar campos vazios
    JOptionPane.showMessageDialog(
        this,
        "Informe o número do quarto."
    );
    return;
}

if (ComboCategoria.getSelectedItem() == null) {
    JOptionPane.showMessageDialog(
        this,
        "Selecione uma categoria."
    );
    return;
}
      
      boolean salvou = dao.salvar(q);
      if (salvou) {
    JOptionPane.showMessageDialog(this, "Cadastrado com sucesso");
    limpar();
    AtualizarTabela();
} else {
    JOptionPane.showMessageDialog(this, "Erro ao salvar no banco");
}
     }

        public void AtualizarTabela(){ //METODO PARA ATUALIZAR TABELA (TELA PRINCIPAU)

    //QuartoDao dao = new QuartoDao(); // CRIANDO CONEXAO COM O DAO  PARA ACESSAR BANCO DE DADOS
    java.util.List<QuartoModel> lista = dao .listar(); // RESPONSAVEL POR PEGAR TODOS OS CLIENTES NO BANCO
    carregarTabela(lista); // COLOCAR OS CLIENTES DENTRO DA TABELA 
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        TextNumero = new javax.swing.JTextField();
        ComboCategoria = new javax.swing.JComboBox<>();
        jButton2 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableQuarto = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(34, 2, 32));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 18)); // NOI18N
        jLabel1.setText("CATEGORIA:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, -1, -1));

        jLabel2.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 18)); // NOI18N
        jLabel2.setText("NUMERO:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 130, -1, -1));

        TextNumero.setBackground(new java.awt.Color(241, 243, 247));
        TextNumero.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        TextNumero.setBorder(null);
        TextNumero.addActionListener(this::TextNumeroActionPerformed);
        getContentPane().add(TextNumero, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 130, 120, 30));

        ComboCategoria.setBackground(new java.awt.Color(241, 238, 246));
        ComboCategoria.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        ComboCategoria.setBorder(null);
        ComboCategoria.setOpaque(true);
        ComboCategoria.addActionListener(this::ComboCategoriaActionPerformed);
        getContentPane().add(ComboCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 130, 150, 30));

        jButton2.setBackground(new java.awt.Color(106, 141, 243));
        jButton2.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 18)); // NOI18N
        jButton2.setText("Cadastrar");
        jButton2.setBorder(null);
        jButton2.addActionListener(this::jButton2ActionPerformed);
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 400, -1, -1));

        jButton15.setBackground(new java.awt.Color(106, 141, 243));
        jButton15.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 18)); // NOI18N
        jButton15.setText("Categoria ");
        jButton15.setBorder(null);
        jButton15.setMargin(new java.awt.Insets(2, 0, 0, 0));
        jButton15.addActionListener(this::jButton15ActionPerformed);
        getContentPane().add(jButton15, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 400, 100, 20));

        TableQuarto.setBackground(new java.awt.Color(206, 207, 209));
        TableQuarto.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        TableQuarto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "QUARTO", "TIPO"
            }
        ));
        TableQuarto.setGridColor(new java.awt.Color(255, 255, 255));
        jScrollPane1.setViewportView(TableQuarto);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, 750, 190));

        jButton1.setBackground(new java.awt.Color(106, 141, 243));
        jButton1.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 18)); // NOI18N
        jButton1.setText("Voltar");
        jButton1.setBorder(null);
        jButton1.addActionListener(this::jButton1ActionPerformed);
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 400, -1, -1));

        jButton3.setBackground(new java.awt.Color(106, 141, 243));
        jButton3.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 18)); // NOI18N
        jButton3.setText("Excluir");
        jButton3.setBorder(null);
        jButton3.addActionListener(this::jButton3ActionPerformed);
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 400, -1, -1));

        jLabel3.setFont(new java.awt.Font("Yu Gothic Light", 0, 36)); // NOI18N
        jLabel3.setText("Cadatro quarto");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 0, 240, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon("C:\\Users\\maury\\OneDrive\\Documentos\\NetBeansProjects\\ProjetoIntegradorUC15\\src\\main\\java\\Telas\\IMGCadastroQuarto.png")); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 750, 470));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TextNumeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextNumeroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextNumeroActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      
        Principal p = new Principal(usuarioLogado);
        p.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void ComboCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboCategoriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboCategoriaActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        salvar();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        //  Captura o índice da linha que o usuário clicou na tabela 
    int linha = TableQuarto.getSelectedRow();

    //  Se o usuário não selecionou nenhuma linha, avisa e interrompe o método
    if (linha == -1) {
        JOptionPane.showMessageDialog(this, "Selecione um registro para excluir!");
        return;
    }

    try {
        int idQuarto = Integer.parseInt(TableQuarto.getValueAt(linha, 0).toString());
dao.Excluir(idQuarto);
        
        int confirm = JOptionPane.showConfirmDialog(
            this,
            "Deseja realmente excluir esta categoria?",
            "Confirmação de Exclusão",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE
        );

        // Se o usuário clicar em "Não" (NO_OPTION) ou fechar a janela, cancela a exclusão
        if (confirm != JOptionPane.YES_OPTION) {
            return;
        }

        // 4. Executa a exclusão chamando o método correspondente no seu DAO
        boolean excluido = dao.Excluir(idQuarto);

        // 5. Verifica se o banco de dados conseguiu deletar o registro com sucesso
        if (excluido) {
            JOptionPane.showMessageDialog(this, "Categoria excluída com sucesso!");
            
            // 6. Recarrega a tabela na tela para fazer sumir a linha deletada
            AtualizarTabela(); 
            
            // Opcional: Limpa os campos de texto caso o usuário estivesse editando algo
            limpar(); 
        } else {
            // Caso o DAO retorne false por algum motivo interno
            JOptionPane.showMessageDialog(this, "Não foi possível excluir. Verifique se existem quartos vinculados a esta categoria.");
        }

    } catch (NumberFormatException e) {
        // Trata falhas caso o valor da coluna 0 não seja um número válido
        JOptionPane.showMessageDialog(this, "Erro ao processar o ID do registro selecionado.");
    } catch (Exception e) {
        // Captura erros gerais, como perda de conexão com o banco de dados
        JOptionPane.showMessageDialog(this, "Erro interno no banco de dados ao tentar excluir: " + e.getMessage());
    }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        CategoriaQuarto quarto = new CategoriaQuarto(usuarioLogado);
        quarto.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton15ActionPerformed

    /**
     * @param args the command line arguments
     */
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<CategoriaQuartoModel> ComboCategoria;
    private javax.swing.JTable TableQuarto;
    private javax.swing.JTextField TextNumero;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
