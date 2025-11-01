package dev.gustavorosa.cobranca_cp.service;

import com.lowagie.text.*;
import com.lowagie.text.Font;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import dev.gustavorosa.cobranca_cp.model.Cliente;
import dev.gustavorosa.cobranca_cp.model.Contrato;
import dev.gustavorosa.cobranca_cp.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.io.ByteArrayOutputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class RelatorioCobrancaService {

  private final ClienteRepository clienteRepository;

  public RelatorioCobrancaService(ClienteRepository clienteRepository) {
    this.clienteRepository = clienteRepository;
  }

  public byte[] gerarRelatorioPorCliente(Long clienteId) {
    Cliente cliente = clienteRepository.findById(clienteId)
        .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

    try {
      Document document = new Document(PageSize.A4, 36, 36, 54, 36);
      ByteArrayOutputStream out = new ByteArrayOutputStream();
      PdfWriter.getInstance(document, out);
      document.open();

      // Cabeçalho
      Font titleFont = new Font(Font.HELVETICA, 18, Font.BOLD, Color.BLACK);
      Paragraph titulo = new Paragraph("Relatório de Cobranças - Cliente", titleFont);
      titulo.setAlignment(Element.ALIGN_CENTER);
      document.add(titulo);

      document.add(new Paragraph("Emitido em: " + LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))));
      document.add(new Paragraph(" "));

      // Dados do cliente
      Font subFont = new Font(Font.HELVETICA, 12, Font.BOLD);
      document.add(new Paragraph("Dados do Cliente", subFont));
      document.add(new Paragraph("Nome: " + cliente.getNome()));
      document.add(new Paragraph("Telefone: " + cliente.getTelefone()));
      document.add(new Paragraph("Endereço: " + (cliente.getEndereco() != null ? cliente.getEndereco() : "-")));
      document.add(new Paragraph("Banco: " + (cliente.getBanco() != null ? cliente.getBanco() : "-")));
      document.add(new Paragraph("Registro: " + cliente.getRegistro()));
      document.add(new Paragraph(" "));

      // Tabela de contratos
      List<Contrato> contratos = cliente.getContratos();
      if (contratos.isEmpty()) {
        document.add(new Paragraph("⚠️ Nenhum contrato encontrado para este cliente."));
      } else {
        PdfPTable tabela = new PdfPTable(5);
        tabela.setWidthPercentage(100);
        tabela.setWidths(new float[] { 2, 3, 2, 2, 2 });
        addHeader(tabela, "ID", "Contratante", "Data Início", "Duração (meses)", "Valor (R$)");

        double total = 0;
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        for (Contrato c : contratos) {
          tabela.addCell(String.valueOf(c.getId()));
          tabela.addCell(c.getNomeContratante());
          tabela.addCell(c.getDataInicioContrato() != null ? c.getDataInicioContrato().format(fmt) : "-");
          tabela.addCell(c.getDuracaoEmMeses() != null ? c.getDuracaoEmMeses().toString() : "-");
          tabela.addCell(String.format("%.2f", c.getValorContrato() != null ? c.getValorContrato() : 0.0));
          total += c.getValorContrato() != null ? c.getValorContrato() : 0.0;
        }

        document.add(tabela);
        document.add(new Paragraph(" "));
        document.add(new Paragraph("Total de contratos: " + contratos.size()));
        document.add(new Paragraph(String.format("Valor total: R$ %.2f", total)));
      }

      document.close();
      return out.toByteArray();

    } catch (Exception e) {
      throw new RuntimeException("Erro ao gerar relatório PDF: " + e.getMessage(), e);
    }
  }

  private void addHeader(PdfPTable tabela, String... headers) {
    Font font = new Font(Font.HELVETICA, 12, Font.BOLD, Color.WHITE);
    for (String h : headers) {
      PdfPCell cell = new PdfPCell(new Phrase(h, font));
      cell.setBackgroundColor(new Color(60, 60, 60));
      cell.setHorizontalAlignment(Element.ALIGN_CENTER);
      tabela.addCell(cell);
    }
  }
}
