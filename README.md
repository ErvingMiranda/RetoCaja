# Reto de caja de ventas concurrente

**Asignatura:** Programación de Aplicaciones de Escritorio  
**Fecha:** 21 de octubre de 2026  
**Elaborado por:** Erving Miranda

Reto de caja de ventas concurrente del HTML *Concurrencia en Java 21*. Tiene como objetivo dar un primer acercamiento a los conceptos de hilos (*threads*), concurrencia y sincronización en Java.

## ¿Cómo evita esta solución una condición de carrera al modificar los valores compartidos?

Con synchronized: Los vendedores registran sus ventas uno a la vez, evitando que se repitan los números del contador y asegurando que el total recaudado sea correcto.

Sin synchronized: Dos vendedores podrían actualizar el contador al mismo tiempo, provocando que se repita un número de venta y que el total sea incorrecto. Como son pocos registros, es posible que el programa funcione correctamente, pero mientras más operaciones se realicen, mayor será la probabilidad de que ocurra una condición de carrera.