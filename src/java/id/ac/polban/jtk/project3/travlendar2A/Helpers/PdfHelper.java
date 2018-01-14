/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.polban.jtk.project3.travlendar2A.Helpers;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mufidjamaluddin
 */
public class PdfHelper 
{
    
    /**
     * Wirter
     */
    private final PdfWriter writer;
    
    /**
     * Document 
     */
    private final Document doc;
    
    /**
     * Header
     */
    private PdfPTable header;
    
    /**
     * Footer
     */
    private PdfPTable footer;
    
    /**
     * Table
     */
    private PdfPTable table;
    
    /**
     * hitungan row table
     */
    private int count;
    
    /**
     * Username
     */
    private final String fullname;
    
    /**
     * alamat Logo
     */
    private final String uriImageLogo;
    
    /**
     * Halaman pdf
     */
    private Integer page;
    
    /**
     * Harus Isi Document tempat write pdf
     * @param writer
     * @param doc 
     * @param fullname 
     * @param uriImageLogo 
     */
    public PdfHelper(PdfWriter writer, Document doc, String fullname, String uriImageLogo)
    {
        this.doc = doc;
        this.header = null;
        this.footer = null;
        this.count = 0;
        this.page = 1;
        this.fullname = fullname;
        this.uriImageLogo = uriImageLogo;
        this.writer = writer;
    }
    
    /**
     * Membuat Cell untuk Table
     * @param font
     * @param color
     * @param text
     * @return 
     */
    private PdfPCell generateCell(Font font, BaseColor color, String text, boolean isCenter)
    {
        Phrase phrase = new Phrase(text, font);
        phrase.setLeading(23, 0);
        PdfPCell cell = new PdfPCell(phrase);
        cell.setBackgroundColor(color);
        cell.setPaddingBottom(3);
        cell.setPaddingTop(3);
        cell.setBorder(Rectangle.BOTTOM);
        cell.setBorderColor(BaseColor.LIGHT_GRAY);
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        if(isCenter)
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        
        return cell;
    }
    
    /**
     * Table Row Pertama
     * @param rowsAttr
     * @param relativeLength 
     */
    public void generatedTable(String[] rowsAttr, int[] relativeLength)
    {
        try 
        {   
            this.table = new PdfPTable(rowsAttr.length);
            this.table.setLockedWidth(true);
            this.table.setTotalWidth(527);
            
            this.table.setWidths(relativeLength);
            this.table.setHeaderRows(1);
            this.table.setSplitRows(false);
            
            //table.setComplete(false);
            Font font = FontFactory.getFont(FontFactory.HELVETICA, 11, Font.BOLD, BaseColor.WHITE);
            BaseColor color = BaseColor.DARK_GRAY;
            
            for (String content : rowsAttr) 
            {
                this.table.addCell(this.generateCell(font, color, content, true));
            }
            
            this.doc.add(this.table);
        } 
        catch (DocumentException ex) 
        {
            Logger.getLogger(PdfHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Membuat row ke table yang sudah ada.
     * Satu halaman maks 8 row
     * @param font
     * @param color
     * @param contentCells 
     */
    public void addRow(Font font, BaseColor color, String... contentCells)
    {
        if(this.table == null) System.out.println("Wajib Buat Table Dulu !"); 
        else 
        {
            /**
             * melanjutkan table lama
             */
            this.table.isComplete();
            /**
             * Skip Header
             */
            this.table.isSkipFirstHeader();

            /**
             * Loop semua isi konten
             */
            for(String contentCell : contentCells)
            {      
                this.table.addCell(this.generateCell(font, color, contentCell, false));
            }
            
            /**
             * Hitung
             */
            this.count++;
            
            /**
             * Tambahkan ke dokumen
             *
            try 
            {
                if(this.count > 8)
                {
                    this.doc.add(this.table);
                    this.addFooter();
                    
                    this.table.deleteBodyRows();
                    this.doc.newPage();
                    this.count = 0;
                }
                
            }
            catch (DocumentException ex) 
            {
                Logger.getLogger(PdfHelper.class.getName()).log(Level.SEVERE, null, ex);
            }
            * */
        }
    }
    
    /**
     * Menambahkan Paragraph
     * @param content
     */
    public void addParagraph(String content)
    {
        try 
        {
            this.doc.add(new Paragraph(content));
        } 
        catch (DocumentException ex) 
        {
            Logger.getLogger(PdfHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Mendapatkan Image 
     * @param uri
     * @return 
     */
    private Image getImage(String uri)
    {
        Image image = null;
        try 
        {
            image = Image.getInstance(uri);
            
        } 
        catch (BadElementException | IOException ex) 
        {
            Logger.getLogger(PdfHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return image;
    }
    
    /**
     * Menambahkan Header
     */
    public void addHeader()
    {
        /**
         * Jika header nya null
         */
        if(this.header == null)
        {
            this.header = new PdfPTable(2);
            try 
            {    
                // set default 
                this.header.setWidths(new int[]{2, 24});
                this.header.setTotalWidth(527);
                this.header.setLockedWidth(true);
                this.header.getDefaultCell().setFixedHeight(40);
                this.header.getDefaultCell().setBorder(Rectangle.BOTTOM);
                this.header.getDefaultCell().setBorderColor(BaseColor.LIGHT_GRAY);

                // tbh image
                Image imageLogo = this.getImage(this.uriImageLogo);
               // PdfPCell containerImage;
               // containerImage = new PdfPCell(imageLogo, true);
                this.header.addCell(imageLogo);

                // tbh text
                PdfPCell text = new PdfPCell();
                text.setPaddingBottom(15);
                text.setPaddingLeft(10);
                text.setBorder(Rectangle.BOTTOM);
                text.setBorderColor(BaseColor.LIGHT_GRAY);
                text.addElement(new Phrase(String.join(" ", "The", fullname, "'s Travel Plan"), new Font(Font.FontFamily.HELVETICA, 12)));
                text.addElement(new Phrase("http://a2.proyek3.jtk.polban.ac.id/", new Font(Font.FontFamily.HELVETICA, 8)));
                this.header.addCell(text);
            } 
            catch (DocumentException ex) 
            {
                Logger.getLogger(PdfHelper.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        /**
         * Tambahkan ke document
         */
        try 
        {
            this.doc.add(this.header);
        } 
        catch (DocumentException ex) 
        {
            Logger.getLogger(PdfHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Menambahkan Footer
     */
    public void addFooter()
    {
        /**
         * Jika footer nya null
         */
        if(this.footer == null)
        {
            this.footer = new PdfPTable(2);
            try 
            { 
                // set default
                this.footer.setWidths(new int[]{24, 2});
                this.footer.setTotalWidth(527);
                this.footer.setLockedWidth(true);
                this.footer.getDefaultCell().setFixedHeight(40);
                this.footer.getDefaultCell().setBorder(Rectangle.TOP);
                this.footer.getDefaultCell().setBorderColor(BaseColor.LIGHT_GRAY);

                // tbh copyright
                this.footer.addCell(new Phrase("\u00A9 Travlendar2A", new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD)));

                // tbh halaman
                this.footer.getDefaultCell().setHorizontalAlignment(Element.ALIGN_RIGHT);
                this.footer.addCell(new Phrase(this.fullname, new Font(Font.FontFamily.HELVETICA, 8)));
            } 
            catch (DocumentException ex) 
            {
                Logger.getLogger(HeaderFooterDocPdf.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        /**
         * Tambahkan ke document
         */
        
        try 
        {
            this.doc.add(this.table);
            this.doc.add(new Phrase("\n\n"));
            this.doc.add(this.footer);
        } 
        catch (DocumentException ex) 
        {
            Logger.getLogger(PdfHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
         
        this.page++;
        // Posisi rowstart 0, rowend -1 artinya print row keatas
        // posisi vertikal dari margin kiri 
        // posisi horizontal itu jumlah total height table footer + ukuran document minus margin bottom ( dari bottom )
        // canvas nya document     
        //this.footer.writeSelectedRows(0, -1, this.doc.left(this.doc.leftMargin()), this.footer.getTotalHeight() + this.doc.bottom(this.doc.bottomMargin()), this.writer.getDirectContent());
    }

    /**
     * @return the doc
     */
    public Document getDoc() 
    {
        return doc;
    }
    
    /**
     * Mendapatkan font normal
     * @return 
     */
    public Font getNormalFont()
    {
        Font font = FontFactory.getFont(FontFactory.HELVETICA_OBLIQUE, 10, Font.NORMAL, BaseColor.DARK_GRAY);
        return font;
    }
    
    /**
     * Base color putih
     * @return 
     */
    public BaseColor getLightBasePdfColor()
    {
        BaseColor color = BaseColor.WHITE;
        return color;
    }

    /**
     * @return the page
     */
    public Integer getCount() 
    {
        return this.count;
    }
    
    /**
     * @return the page
     */
    public Integer getPage() 
    {
        return this.page;
    }
    
}
