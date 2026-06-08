
package Telas;

import Dao.CategoriaQuartoDao;
import Model.CategoriaQuartoModel;
import Model.UsuarioHospedagem;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class CategoriaQuarto extends javax.swing.JFrame {
    
  // Gerenciador de logs para registrar eventos do sistema caso necessário (boas práticas)
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(CategoriaQuarto.class.getName());
    
    // Atributo que guarda a referência da tela de cadastro de quartos (permite comunicação entre telas)
    private TelaCadastroQuarto telacadastroquarto; 

    // Criação do objeto DAO global que será reutilizado em toda a classe para acessar o banco de dados
    private CategoriaQuartoDao dao = new CategoriaQuartoDao(); 
    
    /**
     * Construtor da classe. É executado assim que a tela é chamada/instanciada.
     * @param telacadastroquarto Instância da tela principal que chamou esta janela.
     */private UsuarioHospedagem usuarioLogado;
    public CategoriaQuarto(UsuarioHospedagem usuario) {
        initComponents();
        this.usuarioLogado = usuario;
        AtualizarTabela();        // Chama o método para listar os dados do banco assim que a tela abre
         
    }
    
    /**
     * Método responsável por limpar o texto de todos os campos de entrada da tela.
     */
    private void limpar(){
        TextCategoria.setText("");  // Limpa o campo de texto da Categoria
        TextCapacidade.setText(""); // Limpa o campo de texto da Capacidade
        TextValor.setText("");      // Limpa o campo de texto do Valor/Preço
    }

    /**
     * Método responsável por validar os campos, montar o objeto e salvar as informações no banco.
     */
    private void salvar() {
        // Validação: Verifica se algum dos campos está vazio (o trim() remove espaços em branco inúteis)
        if (TextCategoria.getText().trim().isEmpty() ||
            TextCapacidade.getText().trim().isEmpty() ||
            TextValor.getText().trim().isEmpty()) {
            
            // Exibe mensagem de erro caso falte preencher algo e interrompe a execução com o 'return'
            JOptionPane.showMessageDialog(null, "É obrigatório preencher todos os campos!");
            return;
        }

        // Bloco try-catch para capturar possíveis erros de digitação do usuário (letras no lugar de números)
        try {
            // Instancia um novo objeto de modelo para receber os dados da tela
            CategoriaQuartoModel quarto = new CategoriaQuartoModel();
            
            // Define os valores digitados pelo usuário dentro do objeto modelo
            quarto.setCategoria(TextCategoria.getText());
            quarto.setCapacidade(TextCapacidade.getText());
            
            
            // Converte o texto do valor para Double (aceitando decimais) e substitui a vírgula por ponto
            quarto.setValor(Double.parseDouble(TextValor.getText().replace(",", "."))); 
            
            // Envia o objeto preenchido para o método salvar do DAO, que retorna verdadeiro ou falso
            boolean salvo = dao.salvar(quarto);
            
            // Verifica se a gravação no banco de dados foi bem-sucedida
            if (salvo) {
                JOptionPane.showMessageDialog(null, "Categoria de quarto salva com sucesso!");
                limpar();          // Limpa os campos de texto após o sucesso
                AtualizarTabela(); // Recarrega os dados na tabela para mostrar o novo item inserido
            } else { 
                // Mensagem exibida caso ocorra algum erro interno no banco de dados
                JOptionPane.showMessageDialog(null, "Erro ao salvar a categoria do quarto.");
            }
            
        } catch (NumberFormatException e) {
            // Captura o erro caso o usuário digite texto em campos que deveriam ser estritamente numéricos
            JOptionPane.showMessageDialog(null, "O campo VALOR contém caracteres inválidos. Digite apenas números.");
        }
    }
    
    /**
     * Método responsável por renderizar e preencher a tabela estrutural (JTable) na tela.
     * @param lista Lista de categorias de quartos vindas do banco de dados.
     */
    private void carregarTabela(List<CategoriaQuartoModel> lista) {
        // Cria a estrutura padrão de linhas e colunas para a tabela
        DefaultTableModel model = new DefaultTableModel();

        // Define os títulos das colunas na cabeçalho da tabela
        model.addColumn("ID");
        model.addColumn("CATEGORIA");
        model.addColumn("CAPACIDADE");
        model.addColumn("PREÇO");

        // Varre a lista de objetos (Foreach) e adiciona cada linha na tabela
        for (CategoriaQuartoModel c : lista) {
            model.addRow(new Object[]{
                c.getIdCategoria(), // Coluna ID
                c.getCategoria(),   // Coluna Categoria
                c.getCapacidade(),  // Coluna Capacidade
                c.getValor(),       // Coluna Preço
            });
        }

        // Aplica o modelo estruturado com os dados diretamente no componente visual da tabela
        TableCategoria.setModel(model);
    }

    /**
     * Método público utilizado para buscar as informações atualizadas no banco e enviar para a tabela.
     */
    public void AtualizarTabela() { 
        // Executa a consulta no banco de dados trazendo todos os registros cadastrados
        List<CategoriaQuartoModel> lista = dao.listar(); 
        
        // Passa a lista atualizada de registros para que o componente visual seja redesenhado
        carregarTabela(lista); 
    }
    
    // O NetBeans gerará automaticamente o método initComponents() e as declarações das variáveis abaixo.
    // Exemplo: private javax.swing.JTextField TextCategoria;
    // Exemplo: private javax.swing.JTable TableCategoria;
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        TableCategoria = new javax.swing.JTable();
        ButonExcluir = new javax.swing.JButton();
        ButonCadastra = new javax.swing.JButton();
        ButonInicio = new javax.swing.JButton();
        TextCategoria = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        TextCapacidade = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        TextValor = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TableCategoria.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3"
            }
        ));
        jScrollPane1.setViewportView(TableCategoria);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 250, 670, 160));

        ButonExcluir.setBackground(new java.awt.Color(106, 141, 243));
        ButonExcluir.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        ButonExcluir.setText("Excluir");
        ButonExcluir.setBorder(null);
        ButonExcluir.addActionListener(this::ButonExcluirActionPerformed);
        getContentPane().add(ButonExcluir, new org.netbeans.lib.awtextra.AbsoluteConstraints(325, 210, -1, -1));

        ButonCadastra.setBackground(new java.awt.Color(106, 141, 243));
        ButonCadastra.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        ButonCadastra.setText("Cadastrar");
        ButonCadastra.setBorder(null);
        ButonCadastra.addActionListener(this::ButonCadastraActionPerformed);
        getContentPane().add(ButonCadastra, new org.netbeans.lib.awtextra.AbsoluteConstraints(95, 208, -1, -1));

        ButonInicio.setBackground(new java.awt.Color(106, 141, 243));
        ButonInicio.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        ButonInicio.setText("Inicio");
        ButonInicio.setBorder(null);
        ButonInicio.addActionListener(this::ButonInicioActionPerformed);
        getContentPane().add(ButonInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(522, 211, 80, -1));

        TextCategoria.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        TextCategoria.setBorder(null);
        TextCategoria.addActionListener(this::TextCategoriaActionPerformed);
        getContentPane().add(TextCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(545, 75, 79, 23));

        jLabel2.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 18)); // NOI18N
        jLabel2.setText("categoria:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, -1, -1));

        TextCapacidade.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        TextCapacidade.setBorder(null);
        TextCapacidade.addActionListener(this::TextCapacidadeActionPerformed);
        getContentPane().add(TextCapacidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(363, 75, 100, 25));

        jLabel4.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 18)); // NOI18N
        jLabel4.setText("capacidade");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 70, -1, -1));

        TextValor.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        TextValor.setBorder(null);
        getContentPane().add(TextValor, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 75, 80, 25));

        jLabel3.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 18)); // NOI18N
        jLabel3.setText("valor:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 70, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\maury\\OneDrive\\Documentos\\NetBeansProjects\\ProjetoIntegradorUC15\\src\\main\\java\\Telas\\IMGCAtegoria.png")); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 670, 430));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TextCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextCategoriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextCategoriaActionPerformed

    private void ButonCadastraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButonCadastraActionPerformed
        salvar();
    }//GEN-LAST:event_ButonCadastraActionPerformed

    private void ButonInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButonInicioActionPerformed
        // TODO add your handling code here:
        Principal principal = new Principal(usuarioLogado);
        principal.setVisible(true);
        this.dispose();
        
        
    }//GEN-LAST:event_ButonInicioActionPerformed

    private void TextCapacidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextCapacidadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextCapacidadeActionPerformed

    private void ButonExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButonExcluirActionPerformed
        // Método associado ao evento de clique do botão "Excluir"

    
    // 1. Captura o índice da linha que o usuário clicou na tabela (-1 significa nenhuma linha selecionada)
    int linha = TableCategoria.getSelectedRow();

    // Validação: Se o usuário não selecionou nenhuma linha, avisa e interrompe o método
    if (linha == -1) {
        JOptionPane.showMessageDialog(this, "Selecione um registro para excluir!");
        return;
    }

    try {
        // 2. Recupera o ID da categoria que está na linha selecionada, coluna 0 (primeira coluna da tabela)
        // Convertemos o valor da célula para String e depois para Integer (ajuste para Long.parseLong se o seu ID for Long)
        int idCategoria = Integer.parseInt(TableCategoria.getValueAt(linha, 0).toString());

        // 3. Abre uma caixa de diálogo perguntando se o usuário tem certeza (Evita cliques acidentais)
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
        boolean excluido = dao.Excluir(idCategoria);

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


    }//GEN-LAST:event_ButonExcluirActionPerformed

    /**
     * @param args the command line arguments
     */
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButonCadastra;
    private javax.swing.JButton ButonExcluir;
    private javax.swing.JButton ButonInicio;
    private javax.swing.JTable TableCategoria;
    private javax.swing.JTextField TextCapacidade;
    private javax.swing.JTextField TextCategoria;
    private javax.swing.JTextField TextValor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
