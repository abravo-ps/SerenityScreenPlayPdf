Feature: Validar generacion de pdf

  Scenario: Validar el pdf
    Given Alberto navega hasta la pagina de tasas y tarifas
    When el abre el pdf
    Then el Pdf tiene la informacion siguiente:
    | Titulo  | Prohibiciones |
    | Acuerdo | 4-2011        |