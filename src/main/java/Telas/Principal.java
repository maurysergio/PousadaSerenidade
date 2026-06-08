package Telas;


import Dao.ReservaDao;
import Model.Reserva;
import Model.UsuarioHospedagem;
import javax.swing.JOptionPane;




public class Principal extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Principal.class.getName());
private UsuarioHospedagem usuarioLogado;


    public Principal(UsuarioHospedagem usuario) {
        initComponents();
        this.usuarioLogado = usuario;
         AtualizarTabela(); // CHAMANDO O METODO PARA ATUALIZAR ATABELA ASSIM QUE ABRI A TELA 
          aplicarPermissoes();
    }
ReservaDao dao = new ReservaDao();

private void carregarTabela(java.util.List<Reserva> lista) {

    javax.swing.table.DefaultTableModel model =
            new javax.swing.table.DefaultTableModel();

    model.addColumn("ID");
    model.addColumn("CLIENTE");
    model.addColumn("QUARTO");
    model.addColumn("ENTRADA");
    model.addColumn("SAIDA");
    model.addColumn("STATUS");

    // FORMATADOR QUE AJUSTA PARA O PADRÃO BRASILEIRO
    java.text.SimpleDateFormat formatador = new java.text.SimpleDateFormat("dd/MM/yyyy");

    for (Reserva r : lista) {
        String dataEntradaFormatada = "";
        String dataSaidaFormatada = "";

        // Formata a data de entrada se ela não estiver vazia no banco
        if (r.getDataentrada() != null) {
            dataEntradaFormatada = formatador.format(r.getDataentrada());
        } else {
            dataEntradaFormatada = "-";
        }

        // Formata a data de saída se ela não estiver vazia no banco
        if (r.getDatasaida() != null) {
            dataSaidaFormatada = formatador.format(r.getDatasaida());
        } else {
            dataSaidaFormatada = "-";
        }

        model.addRow(new Object[]{
            r.getIdReserva(),
            r.getCliente(),
            r.getQuarto(),
            dataEntradaFormatada, // DATA ENTRADA CORRIGIDA (DD/MM/AAAA)
            dataSaidaFormatada,   // DATA SAÍDA CORRIGIDA (DD/MM/AAAA)
            r.getStatus()
        });
    }

    TableCheck.setModel(model);


}
private void aplicarPermissoes() {

    if(usuarioLogado == null){
        return;
    }

    if(usuarioLogado.getTipo().equalsIgnoreCase("RECEPCIONISTA")){

        // bloquear funcionalidades administrativas
        BtnCadastroQuarto.setVisible(false);

    }

}

public void AtualizarTabela() {

    ReservaDao dao = new ReservaDao();

    java.util.List<Reserva> lista =
            dao.listar();

    carregarTabela(lista);
}

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton2 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        TableCheck = new javax.swing.JTable();
        BtnCadastroQuarto = new javax.swing.JButton();
        BtnCadastroCliente = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        txtBuscarCliente = new javax.swing.JTextField();
        BntBuscar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        jButton2.setText("jButton2");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("acesso ao sistema ");
        setBackground(new java.awt.Color(133, 157, 255));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TableCheck.setBackground(new java.awt.Color(204, 204, 208));
        TableCheck.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        TableCheck.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "NOME", "CPF", "ENDEREÇO"
            }
        ));
        TableCheck.setAlignmentX(0.0F);
        TableCheck.setGridColor(new java.awt.Color(255, 255, 255));
        TableCheck.setMaximumSize(new java.awt.Dimension(2147483647, 60));
        TableCheck.setMinimumSize(new java.awt.Dimension(30, 600));
        TableCheck.setPreferredSize(new java.awt.Dimension(150, 600));
        TableCheck.setSelectionBackground(new java.awt.Color(204, 204, 204));
        jScrollPane2.setViewportView(TableCheck);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 220, 770, 170));

        BtnCadastroQuarto.setBackground(new java.awt.Color(106, 141, 243));
        BtnCadastroQuarto.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        BtnCadastroQuarto.setText("CADASTRO QUARTO");
        BtnCadastroQuarto.setAlignmentY(0.0F);
        BtnCadastroQuarto.setBorder(null);
        BtnCadastroQuarto.setMargin(new java.awt.Insets(2, 5, 3, 5));
        BtnCadastroQuarto.addActionListener(this::jButton6ActionPerformed);
        getContentPane().add(BtnCadastroQuarto, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 170, 150, 20));

        BtnCadastroCliente.setBackground(new java.awt.Color(106, 141, 243));
        BtnCadastroCliente.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        BtnCadastroCliente.setText("CADASTRAR CLIENTE");
        BtnCadastroCliente.setBorder(null);
        BtnCadastroCliente.setMargin(new java.awt.Insets(2, 5, 3, 5));
        BtnCadastroCliente.addActionListener(this::BtnCadastroClienteActionPerformed);
        getContentPane().add(BtnCadastroCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 170, 150, 20));

        jButton15.setBackground(new java.awt.Color(106, 141, 243));
        jButton15.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jButton15.setText("RESERVA");
        jButton15.setBorder(null);
        jButton15.addActionListener(this::jButton15ActionPerformed);
        getContentPane().add(jButton15, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 130, 20));

        jButton3.setBackground(new java.awt.Color(106, 141, 243));
        jButton3.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 14)); // NOI18N
        jButton3.setText("Realizar Check-in");
        jButton3.setBorder(null);
        jButton3.addActionListener(this::jButton3ActionPerformed);
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 430, 150, -1));

        jButton1.setBackground(new java.awt.Color(106, 141, 243));
        jButton1.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 14)); // NOI18N
        jButton1.setText("Realizar Check-out");
        jButton1.setBorder(null);
        jButton1.addActionListener(this::jButton1ActionPerformed);
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 430, 160, 20));

        txtBuscarCliente.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 14)); // NOI18N
        txtBuscarCliente.setBorder(null);
        getContentPane().add(txtBuscarCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 90, 280, 20));

        BntBuscar.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 18)); // NOI18N
        BntBuscar.setText("Buscar");
        BntBuscar.setBorder(null);
        BntBuscar.addActionListener(this::BntBuscarActionPerformed);
        getContentPane().add(BntBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 90, 70, 20));

        jPanel1.setBackground(new java.awt.Color(217, 217, 217));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 36)); // NOI18N
        jLabel4.setText("Pousada serenidade");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 0, 320, 50));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 770, 50));

        jPanel2.setBackground(new java.awt.Color(217, 217, 217));

        jLabel2.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jLabel2.setText("Pesquisar reservas:");
        jPanel2.add(jLabel2);

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, 170, 30));

        jLabel3.setIcon(new javax.swing.ImageIcon("C:\\Users\\maury\\OneDrive\\Documentos\\NetBeansProjects\\ProjetoIntegradorUC15\\src\\main\\java\\Telas\\IMGPrincipal.png")); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 770, 480));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        TelaCadastroQuarto quarto =new TelaCadastroQuarto(usuarioLogado);
        quarto.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void BtnCadastroClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCadastroClienteActionPerformed
        // TODO add your handling code here:
        CadastroClientes clientes = new CadastroClientes(usuarioLogado);
        clientes.setVisible(true);
       this.dispose();
    }//GEN-LAST:event_BtnCadastroClienteActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        // TODO add your handling code here:
        TelaReserva reserva = new TelaReserva(usuarioLogado);
        reserva.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton15ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        int linha = TableCheck.getSelectedRow();

if (linha == -1) {

    JOptionPane.showMessageDialog(
        this,
        "Selecione uma reserva."
    );

    return;
}

int idReserva =
(Integer) TableCheck.getValueAt(linha, 0);

Reserva reserva =
dao.buscarPorId(idReserva);

reserva.setStatus("HOSPEDADO");

dao.salvar(reserva);

AtualizarTabela();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
                                                  
                                          
        // 1. Verifica se o usuário selecionou uma linha na tabela de reservas
        int linhaSelecionada = TableCheck.getSelectedRow();
        if (linhaSelecionada == -1) {
            JOptionPane.showMessageDialog(this, "Por favor, selecione uma reserva na tabela para realizar o check-out.");
            return;
        }

        try {
            // 2. Captura o ID bruto da reserva na primeira coluna (Coluna 0)
            int idReserva = Integer.parseInt(TableCheck.getValueAt(linhaSelecionada, 0).toString());

            // 3. Busca o objeto completo com os relacionamentos direto do Hibernate
            Dao.ReservaDao reservaDao = new Dao.ReservaDao();
            Model.Reserva reservaBanco = reservaDao.buscarPorId(idReserva);

            if (reservaBanco == null || reservaBanco.getDataentrada() == null || reservaBanco.getDatasaida() == null) {
                JOptionPane.showMessageDialog(this, "Erro: Dados da reserva estão inconsistentes no banco de dados.");
                return;
            }

            // 4. CÁLCULO MATEMÁTICO REAL DO NÚMERO DE DIÁRIAS
            long tempoEntrada = reservaBanco.getDataentrada().getTime();
            long tempoSaida = reservaBanco.getDatasaida().getTime();
            long diferencaEmMilissegundos = tempoSaida - tempoEntrada;
            long totalDias = diferencaEmMilissegundos / (1000 * 60 * 60 * 24);
            
            // Regra: se entrou e saiu no mesmo dia, cobra no mínimo 1 diária
            int diarias = (totalDias <= 0) ? 1 : (int) totalDias;

            // 5. CAPTURA DINÂMICA DO VALOR DA CATEGORIA DO QUARTO
            double valorDiaria = 0.0;
            String nomeCategoria = "Não informada";
            
            // Navega com segurança pelas amarrações: Reserva -> Quarto -> Categoria
            if (reservaBanco.getQuarto() != null && reservaBanco.getQuarto().getCategoria() != null) {
                valorDiaria = reservaBanco.getQuarto().getCategoria().getValor(); // CAPTURA O VALOR REAL DO CADASTRO
                nomeCategoria = reservaBanco.getQuarto().getCategoria().getCategoria();
            } else {
                JOptionPane.showMessageDialog(this, "Aviso: Este quarto não possui valor de categoria cadastrado! Será considerado R$ 0,00.");
            }

            // REALIZA A SOMA/MULTIPLICAÇÃO DO VALOR TOTAL DO PERÍODO
            double valorTotalSoma = diarias * valorDiaria;

            // 6. FORMATAÇÃO DA MENSAGEM DO RECIBO EXIBINDO OS VALORES REAIS DO BANCO
            java.text.SimpleDateFormat sdfBr = new java.text.SimpleDateFormat("dd/MM/yyyy");
            String mensagemRecibo = String.format(
                "┌──────────────────────────────────┐\n" +
                "│          FINALIZAR HOSPEDAGEM          │\n" +
                "└──────────────────────────────────┘\n" +
                "  Cliente: %s\n" +
                "  Quarto: %s (Tipo: %s)\n" +
                "  Entrada: %s\n" +
                "  Saída: %s\n" +
                "  Diárias Calculadas: %d\n" +
                "  Preço da Diária: R$ %.2f\n" +
                "  ---------------------------------\n" +
                "  VALOR TOTAL DA SOMA: R$ %.2f\n\n" +
                "Selecione a forma de pagamento:",
                reservaBanco.getCliente(), 
                reservaBanco.getQuarto() != null ? reservaBanco.getQuarto().getNumero() : "-", 
                nomeCategoria,
                sdfBr.format(reservaBanco.getDataentrada()),
                sdfBr.format(reservaBanco.getDatasaida()),
                diarias, 
                valorDiaria, 
                valorTotalSoma
            );

            // Opções do menu drop-down
            String[] formasPagamento = {"PIX", "Cartão de Crédito", "Cartão de Débito", "Dinheiro"};

            // 7. JANELA DE CONFIRMAÇÃO DO FECHAMENTO E SELEÇÃO DE PAGAMENTO
            Object selecao = JOptionPane.showInputDialog(
                this, mensagemRecibo, "Finalizar Check-out - Pousada Serenidade",
                JOptionPane.PLAIN_MESSAGE, null, formasPagamento, formasPagamento
            );

            // 8. PERSISTÊNCIA DOS DADOS E ATUALIZAÇÃO DE STATUS NO MYSQL
            if (selecao != null) {
                String formaEscolhida = selecao.toString();

                // Registra o financeiro na tabela 'pagamento'
                Model.PagamentoModel novoPagamento = new Model.PagamentoModel();
                novoPagamento.setValorPago(valorTotalSoma); 
                novoPagamento.setMetodo(formaEscolhida);
                
                novoPagamento.setCliente(reservaBanco.getCliente());

                Dao.PagamentoDao pagDao = new Dao.PagamentoDao();
                pagDao.salvar(novoPagamento);

                // Dispara o update automático de status da reserva para FINALIZADO
                reservaDao.atualizarStatus(idReserva, "FINALIZADO");

                JOptionPane.showMessageDialog(this, "Check-out confirmado com sucesso!\nO quarto foi liberado.");
                
                // Recarrega os dados do grid na interface principal
                AtualizarTabela();
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao processar cálculo de check-out: " + e.getMessage());
            e.printStackTrace();
        }
    


    }//GEN-LAST:event_jButton1ActionPerformed

    private void BntBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BntBuscarActionPerformed
        // TODO add your handling code here:
       

    String nome = txtBuscarCliente.getText();

    ReservaDao dao = new ReservaDao();

    java.util.List<Reserva> lista =
            dao.buscarPorCliente(nome);

    carregarTabela(lista);


    }//GEN-LAST:event_BntBuscarActionPerformed

    /**
     * @param args the command line arguments
     */
 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BntBuscar;
    private javax.swing.JButton BtnCadastroCliente;
    private javax.swing.JButton BtnCadastroQuarto;
    private javax.swing.JTable TableCheck;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField txtBuscarCliente;
    // End of variables declaration//GEN-END:variables
}
