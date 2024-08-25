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
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 *
 * @author PC
 */
public class GenerarPdf {
    public void generarPDFTicket(JTable table) {
        Document documento = new Document(PageSize.LETTER.rotate());

        try {
            String ruta = System.getProperty("user.home") + "/Desktop/";
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String fechaActual = sdf.format(new Date());

            String nombreArchivo = "Reporte Tickets " + fechaActual + ".pdf";
            File archivo = new File(ruta + nombreArchivo);

            // Verificar si existe un archivo con el mismo nombre y añadir un número al nombre si es necesario
            int contador = 1;
            while (archivo.exists()) {
                nombreArchivo = "Reporte Tickets " + fechaActual + "(" + contador + ").pdf";
                archivo = new File(ruta + nombreArchivo);
                contador++;
            }

            PdfWriter.getInstance(documento, new FileOutputStream(archivo));
            documento.open();

            // Ajustar márgenes del documento
            documento.setMargins(20, 20, 50, 20); // Margen izquierdo, derecho, superior, inferior

            // Agregar título y fecha al documento
            Paragraph encabezado = new Paragraph("Reporte de Tickets\n");
            encabezado.setSpacingAfter(20);
            documento.add(encabezado);

            Paragraph fecha = new Paragraph("Fecha de generación: " + new SimpleDateFormat("dd/MM/yyyy").format(new Date()));
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
        Document documento = new Document(PageSize.LETTER.rotate());

        try {
            String ruta = System.getProperty("user.home") + "/Desktop/";
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String fechaActual = sdf.format(new Date());

            String nombreArchivo = "Reporte Omnibus " + fechaActual + ".pdf";
            File archivo = new File(ruta + nombreArchivo);

            // Verificar si existe un archivo con el mismo nombre y añadir un número al nombre si es necesario
            int contador = 1;
            while (archivo.exists()) {
                nombreArchivo = "Reporte Omnibus " + fechaActual + "(" + contador + ").pdf";
                archivo = new File(ruta + nombreArchivo);
                contador++;
            }

            PdfWriter.getInstance(documento, new FileOutputStream(archivo));
            documento.open();

            // Ajustar márgenes del documento
            documento.setMargins(20, 20, 50, 20); // Margen izquierdo, derecho, superior, inferior

            // Agregar título y fecha al documento
            Paragraph encabezado = new Paragraph("Reporte de Omnibus\n");
            encabezado.setSpacingAfter(20);
            documento.add(encabezado);

            Paragraph fecha = new Paragraph("Fecha de generación: " + new SimpleDateFormat("dd/MM/yyyy").format(new Date()));
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
        Document documento = new Document(PageSize.LETTER.rotate());

        try {
            String ruta = System.getProperty("user.home") + "/Desktop/";
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String fechaActual = sdf.format(new Date());

            String nombreArchivo = "Reporte Conductor " + fechaActual + ".pdf";
            File archivo = new File(ruta + nombreArchivo);

            // Verificar si existe un archivo con el mismo nombre y añadir un número al nombre si es necesario
            int contador = 1;
            while (archivo.exists()) {
                nombreArchivo = "Reporte Conductor " + fechaActual + "(" + contador + ").pdf";
                archivo = new File(ruta + nombreArchivo);
                contador++;
            }

            PdfWriter.getInstance(documento, new FileOutputStream(archivo));
            documento.open();

            // Ajustar márgenes del documento
            documento.setMargins(20, 20, 50, 20); // Margen izquierdo, derecho, superior, inferior

            // Agregar título y fecha al documento
            Paragraph encabezado = new Paragraph("Reporte de Conductor\n");
            encabezado.setSpacingAfter(20);
            documento.add(encabezado);

            Paragraph fecha = new Paragraph("Fecha de generación: " + new SimpleDateFormat("dd/MM/yyyy").format(new Date()));
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
