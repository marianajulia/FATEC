package com.fatec.cliente_backv2.view;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

import org.junit.jupiter.api.Test;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.junit.UsePlaywright;
import com.microsoft.playwright.options.AriaRole;

@UsePlaywright
public class Req10ConsultaClienteTests {
  @Test
  void test(Page page) {
    page.navigate("http://localhost:5173/");
    page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Consulta de clientes")).click();
    assertThat(page.getByRole(AriaRole.HEADING)).containsText("Consulta de Clientes");
    page.getByRole(AriaRole.CELL, new Page.GetByRoleOptions().setName("Rua João Soliman")).click();
    assertThat(page.locator("tbody")).containsText("Rua João Soliman");
  }
}
