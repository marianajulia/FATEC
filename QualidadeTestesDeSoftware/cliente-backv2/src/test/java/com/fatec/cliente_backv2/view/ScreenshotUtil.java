package com.fatec.cliente_backv2.view;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.microsoft.playwright.Page;

public class ScreenshotUtil {

    public static void takeScreenshot(Page page, String testName) {
        // Formata a data e hora para o nome do arquivo
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
        
        // Constrói o nome do arquivo: NOME_DO_TESTE_TIMESTAMP.png
        String fileName = testName + "_" + timestamp + ".png";

        // Define o caminho absoluto final
        Path fullPath = Paths.get("C:", "edson", "evidencia", fileName);

        System.out.println("Salvando screenshot em: " + fullPath.toString());

        try {
            page.screenshot(new Page.ScreenshotOptions()
                .setPath(fullPath)
                .setFullPage(true)
            );
        } catch (Exception e) {
            System.err.println("ERRO ao salvar a screenshot: " + e.getMessage());
        }
    }
}
