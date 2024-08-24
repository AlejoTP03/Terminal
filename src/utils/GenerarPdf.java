/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import javax.swing.*;
import javax.swing.table.TableModel;
import java.awt.HeadlessException;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 *
 * @author PC
 */
public class GenerarPdf {
    public void generarPDFTicket(JTable table) {
        // Crear un documento en formato Carta y en orientación horizontal
        Document documento = new Document(PageSize.LETTER.rotate());

        try {
            String ruta = System.getProperty("user.home");
            PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/Desktop/Reporte_Tickets.pdf"));
            documento.open();

            // Ajustar márgenes del documento
            documento.setMargins(20, 20, 50, 20); // Margen izquierdo, derecho, superior, inferior

            // Agregar título y fecha al documento
            Paragraph encabezado = new Paragraph("Reporte de Tickets\n");
            encabezado.setSpacingAfter(20);
            documento.add(encabezado);

            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            Paragraph fecha = new Paragraph("Fecha de generación: " + sdf.format(new Date()));
            fecha.setSpacingAfter(20);
            documento.add(fecha);

            // Crear la tabla PDF con el mismo número de columnas que la JTable
            PdfPTable pdfTable = new PdfPTable(table.getColumnCount());

            // Agregar las cabeceras de la tabla
            TableModel model = table.getModel();
            for (int i = 0; i < model.getColumnCount(); i++) {
                pdfTable.addCell(model.getColumnName(i));
            }

            // Agregar las filas de la tabla
            for (int rows = 0; rows < model.getRowCount(); rows++) {
                for (int cols = 0; cols < model.getColumnCount(); cols++) {
                    Object value = model.getValueAt(rows, cols);
                    pdfTable.addCell(value != null ? value.toString() : "");
                }
            }

            // Ajustar la tabla para que se ajuste al ancho de la página
            pdfTable.setWidthPercentage(100); // Asegúrate de que la tabla se ajuste al ancho de la página

            documento.add(pdfTable);

        } catch (DocumentException | HeadlessException | FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (documento.isOpen()) {
                documento.close();
            }
        }
    }

    
    
    
    public void generarPDFOmnibus(JTable table) {
        // Crear un documento en formato Carta y en orientación horizontal
        Document documento = new Document(PageSize.LETTER.rotate());

        try {
            String ruta = System.getProperty("user.home");
            PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/Desktop/Reporte_Omnibus.pdf"));
            documento.open();

            // Ajustar márgenes del documento
            documento.setMargins(20, 20, 50, 20); // Margen izquierdo, derecho, superior, inferior

            // Agregar título y fecha al documento
            Paragraph encabezado = new Paragraph("Reporte de Omnibus\n");
            encabezado.setSpacingAfter(20);
            documento.add(encabezado);

            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            Paragraph fecha = new Paragraph("Fecha de generación: " + sdf.format(new Date()));
            fecha.setSpacingAfter(20);
            documento.add(fecha);

            // Crear la tabla PDF con el mismo número de columnas que la JTable
            PdfPTable pdfTable = new PdfPTable(table.getColumnCount());

            // Agregar las cabeceras de la tabla
            TableModel model = table.getModel();
            for (int i = 0; i < model.getColumnCount(); i++) {
                pdfTable.addCell(model.getColumnName(i));
            }

            // Agregar las filas de la tabla
            for (int rows = 0; rows < model.getRowCount(); rows++) {
                for (int cols = 0; cols < model.getColumnCount(); cols++) {
                    Object value = model.getValueAt(rows, cols);
                    pdfTable.addCell(value != null ? value.toString() : "");
                }
            }

            // Ajustar la tabla para que se ajuste al ancho de la página
            pdfTable.setWidthPercentage(100); // Asegúrate de que la tabla se ajuste al ancho de la página

            documento.add(pdfTable);

        } catch (DocumentException | HeadlessException | FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (documento.isOpen()) {
                documento.close();
            }
        }

    }
    
    
    public void generarPDFConductor(JTable table) {
        // Crear un documento en formato Carta y en orientación horizontal
        Document documento = new Document(PageSize.LETTER.rotate());

        try {
            String ruta = System.getProperty("user.home");
            PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/Desktop/Reporte_Conductor.pdf"));
            documento.open();

            // Ajustar márgenes del documento
            documento.setMargins(20, 20, 50, 20); // Margen izquierdo, derecho, superior, inferior

            // Agregar título y fecha al documento
            Paragraph encabezado = new Paragraph("Reporte de Conductor\n");
            encabezado.setSpacingAfter(20);
            documento.add(encabezado);

            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            Paragraph fecha = new Paragraph("Fecha de generación: " + sdf.format(new Date()));
            fecha.setSpacingAfter(20);
            documento.add(fecha);

            // Crear la tabla PDF con el mismo número de columnas que la JTable
            PdfPTable pdfTable = new PdfPTable(table.getColumnCount());

            // Agregar las cabeceras de la tabla
            TableModel model = table.getModel();
            for (int i = 0; i < model.getColumnCount(); i++) {
                pdfTable.addCell(model.getColumnName(i));
            }

            // Agregar las filas de la tabla
            for (int rows = 0; rows < model.getRowCount(); rows++) {
                for (int cols = 0; cols < model.getColumnCount(); cols++) {
                    Object value = model.getValueAt(rows, cols);
                    pdfTable.addCell(value != null ? value.toString() : "");
                }
            }

            // Ajustar la tabla para que se ajuste al ancho de la página
            pdfTable.setWidthPercentage(100); // Asegúrate de que la tabla se ajuste al ancho de la página

            documento.add(pdfTable);

        } catch (DocumentException | HeadlessException | FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (documento.isOpen()) {
                documento.close();
            }
        }

    }
}
