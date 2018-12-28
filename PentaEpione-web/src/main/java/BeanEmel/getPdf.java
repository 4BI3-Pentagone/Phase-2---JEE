package BeanEmel;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.log.Logger;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfTemplate;
import com.itextpdf.text.pdf.PdfWriter;
@Stateless
@LocalBean
public class getPdf {
	

    public getPdf() {
		//super();
		// TODO Auto-generated constructor stub
	}

	private static Font catFont = new Font(Font.FontFamily.TIMES_ROMAN, 14,
            Font.BOLD, BaseColor.BLACK);
    private static Font redFont = new Font(Font.FontFamily.TIMES_ROMAN, 12,
            Font.NORMAL, BaseColor.BLACK);
    private static Font subFont = new Font(Font.FontFamily.TIMES_ROMAN, 15,
            Font.BOLD, BaseColor.BLACK);
    private static Font Bold = new Font(Font.FontFamily.TIMES_ROMAN, 20,
            Font.BOLD, BaseColor.MAGENTA);

	  void Print() throws DocumentException, IOException {
	        Document doc = new Document();
	        Paragraph paragraph = new Paragraph("Infomaation Equipe", new Font(Font.FontFamily.TIMES_ROMAN, 18,
	                Font.BOLD));
	       // Equipe e = (Equipe) lsteq.getSelectionModel().selectedItemProperty().getValue();
	        PdfWriter writer = null;
	       // if (e != null) {
	            try {

	                int rand = (int) (Math.random() * (1000 - 1));
	                String nomchfich = "Formation.pdf";
	                writer = PdfWriter.getInstance(doc, new FileOutputStream(nomchfich));
	                doc.open();
	                //  doc.add(new Paragraph("Fiche Recapitulative "),Bold);
	               // System.err.println("pdf equipe  " + e.getPays());
	                Paragraph titre = new Paragraph("Fiche Recapitulative ", Bold);
	                titre.setAlignment(Paragraph.ALIGN_CENTER);
	                doc.add(titre);

	                Paragraph p = new Paragraph("test" , Bold);
	                p.setAlignment(Paragraph.ALIGN_CENTER);
	                doc.add(p);
	                doc.add(new Paragraph(" "));
	                doc.add(new Paragraph(" "));
	                doc.add(new Paragraph("Groupe             : ", catFont));
	                doc.add(new Paragraph("Phase              : " , catFont));
	                doc.add(new Paragraph("Selectionneur      : " , catFont));
	                doc.add(new Paragraph("Nombre de But      : " , catFont));
	                doc.add(new Paragraph("Nombre de carton   : " , catFont));
	                doc.add(new Paragraph("Rouge              : ", catFont));
	                doc.add(new Paragraph("Jaune              : " , catFont));
	                doc.add(new Paragraph(" "));
	                doc.add(new Paragraph(" "));
	                doc.add(new Paragraph("Liste des Joueurs              : ", subFont));
	                doc.add(new Paragraph(" "));
	                doc.add(new Paragraph(" "));

	                //--------------------------------------------------------------
	           //     ObservableList<Joueur> joueurs = FXCollections.observableArrayList(sj.chercherParEquipe(e.getPays()));
	                PdfPTable table = new PdfPTable(3);
	                // table.setWidths(new int[]{1, 4});

	                PdfPCell cell1 = new PdfPCell(new Phrase("joueur"));
	                cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
	                cell1.setBorderWidth(2);
	                cell1.setBackgroundColor(BaseColor.LIGHT_GRAY);
	                table.addCell(cell1);

	                cell1 = new PdfPCell(new Phrase("poste"));
	                cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
	                cell1.setBorderWidth(2);
	                cell1.setBackgroundColor(BaseColor.LIGHT_GRAY);
	                table.addCell(cell1);

	                cell1 = new PdfPCell(new Phrase("but"));
	                cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
	                cell1.setBorderWidth(2);
	                cell1.setBackgroundColor(BaseColor.LIGHT_GRAY);
	                table.addCell(cell1);

	                table.setHeaderRows(1);

	                List<String> nom = new ArrayList<>();
	                List<String> but = new ArrayList<>();
	                List<String> poste = new ArrayList<>();
	              /*  for (Joueur joueur : joueurs) {
	                    nom.add(joueur.getNomJoueur());
	                    poste.add(joueur.getPosition());
	                    System.err.println("jjjjjjjj" + joueur);
	                    but.add(String.valueOf(joueur.getNbr_but()));
	                }*/
	              //  System.err.println("taille" + joueurs.size());
	                for (int i = 0; i < 10; i++) {
	                    System.out.println("nom");
	                    table.addCell("tes : "+i);
	                  //  table.addCell(poste.get(i));
	                  //  table.addCell(but.get(i));

	                }

	                /*
	               
	                 */
	            /*    PdfContentByte contentByter = writer.getDirectContent();
	                PdfContentByte contentBytej = writer.getDirectContent();

	                PdfTemplate templatej = contentBytej.createTemplate(200, 200);
	                Graphics2D graphics2dj = templatej.createGraphics(200, 200,
	                        new DefaultFontMapper());
	                Rectangle2D rectangle2dj = new Rectangle2D.Double(0, 0, 200,
	                        200);

	                PdfTemplate templater = contentByter.createTemplate(200, 200);
	                Graphics2D graphics2dr = templater.createGraphics(200, 200,
	                        new DefaultFontMapper());
	                Rectangle2D rectangle2dr = new Rectangle2D.Double(0, 0, 200,
	                        200);

	                contentByter.addTemplate(templater, 10, 20);
	                contentBytej.addTemplate(templatej, 300, 20);
	                JFreeChart chartJ = generatePieChartJ();
	                JFreeChart chartR = generatePieChartR();
	                chartR.draw(graphics2dr, rectangle2dr);
	                chartJ.draw(graphics2dj, rectangle2dj);
	                graphics2dr.dispose();
	                graphics2dj.dispose();*/
	                doc.add(new Paragraph(""));

	                doc.add(table);
	                doc.add(new Paragraph(" "));
	                doc.add(new Paragraph(" "));
	                doc.add(new Paragraph("Statistiques de possesion de carton             : ", subFont));

	                doc.close();
	           /*     Alert alert = new Alert(Alert.AlertType.INFORMATION);
	                alert.setTitle("Information Dialog");
	                alert.setHeaderText(null);
	                alert.setContentText("Le fichier PDF est téléchargé!");
	                alert.showAndWait();*/
	               // Desktop.getDesktop().open(new File("C:\\Users\\Emel\\Documents\\javaproject\\PIDEV1\\" + nomchfich));
	                /*
	                DialogPane dialogPane = alert.getDialogPane();
	                dialogPane.getStylesheets().add(
	                        getClass().getResource("@/Assets/myDialogs.css").toExternalForm());
	                dialogPane.getStyleClass().add("myDialog");
	                 */

	//PdfDecoder pdf = openPdf("Formation.pdf");
	            } catch (FileNotFoundException ex) {
	              //  Logger.getLogger().log(Level.SEVERE, null, ex);
	            } catch (DocumentException ex) {
	       //         Logger.getLogger(GestionEquipeController.class.getName()).log(Level.SEVERE, null, ex);
	            }

	      
	    }
}
