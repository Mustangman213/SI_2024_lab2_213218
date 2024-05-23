# Втора лабораториска вежба по Софтверско инженерство

## Стефан Фрчковски, бр. на индекс 213218

###  Control Flow Graph

![Lab2_SI_213218](https://github.com/Mustangman213/SI_2024_lab2_213218/assets/163764973/18f8c9f4-95f7-4463-9306-ff17b4697420)

### Цикломатска комплексност

Цикломатската комплексност на овој код е 10, истата ја добив преку формулата P+1, каде што P е бројот на предикатни јазли. Во случајoв P=9, па цикломатската комплексност изнесува 10.

### Тест случаи според критериумот  Every statement 

За да постигнеме покриеност на секоја гранка (Every Branch - EB) во функцијата checkCart, треба да создадеме тест случаи кои ги покриваат сите можни гранки на кодот. 

Гранка 1: Проверка дали allItems е null.

Точно: фрли нов RuntimeException("allItems list can't be null!");
Лажно: Продолжи кон петата гранка.
Гранка 2: Итерација преку allItems.

Точно: Влези во петата гранка.
Лажно: Прескокни ја петата ако allItems е празен.
Гранка 3: Проверка дали item.getName() е null или празно.

Точно: item.setName("unknown");
Лажно: Ништо.
Гранка 4: Проверка дали item.getBarcode() не е null.

Точно: Продолжи кон валидација на баркодот.
Лажно: фрли нов RuntimeException("No barcode!");
Гранка 5: Валидација на секој карактер во item.getBarcode().

Точно: Продолжи ако карактерот е валиден.
Лажно: фрли нов RuntimeException("Invalid character in item barcode!");
Гранка 6: Проверка дали item.getDiscount() е поголем од 0.

Точно: sum += item.getPrice()*item.getDiscount();
Лажно: sum += item.getPrice();
Гранка 7: Примена на попуст (item.getPrice() > 300 && item.getDiscount() > 0 && item.getBarcode().charAt(0) == '0').

Точно: sum -= 30;
Лажно: Ништо.
Гранка 8: Финална проверка дали sum <= payment.

Точно: Врати true.
Лажно: Врати false.
Тест Случаи

Тест Случај 1: Null allItems

Влез: allItems = null, payment = any_value
Очекувано: RuntimeException("allItems list can't be null!")
Тест Случај 2: Празно allItems

Влез: allItems = [], payment = 0
Очекувано: true (бидејќи sum е 0, што е <= payment)
Тест Случај 3: Ставка со null име

Влез: allItems = [new Item(null, "123456", 100, 0)], payment = 100
Очекувано: true (името е поставено на "unknown", sum = 100, payment = 100)
Тест Случај 4: Ставка со невалиден баркод

Влез: allItems = [new Item("Item1", "12a456", 100, 0)], payment = 100
Очекувано: RuntimeException("Invalid character in item barcode!")
Тест Случај 5: Ставка со null баркод

Влез: allItems = [new Item("Item1", null, 100, 0)], payment = 100
Очекувано: RuntimeException("No barcode!")
Тест Случај 6: Ставка со попуст и цена <= 300

Влез: allItems = [new Item("Item1", "123456", 200, 0.1)], payment = 180
Очекувано: true (sum = 200 * 0.1 = 20, sum + 200 = 220 што е > payment)
Тест Случај 7: Ставка со цена > 300, попуст > 0, и баркод почнува со '0'

Влез: allItems = [new Item("Item1", "012345", 400, 0.1)], payment = 340
Очекувано: true (sum = 400 * 0.1 = 40, sum + 400 = 440, 440 - 30 = 410, payment = 410)
Тест Случај 8: Ставка со цена > 300, попуст = 0, и баркод почнува со '0'

Влез: allItems = [new Item("Item1", "012345", 400, 0)], payment = 400
Очекувано: true (sum = 400, payment = 400)
Тест Случај 9: Повеќе ставки, мешани услови

Влез: allItems = [new Item("Item1", "123456", 100, 0), new Item("Item2", "654321", 300, 0.2)], payment = 340
Очекувано: true (sum = 100 + (300 * 0.2) + 300 = 100 + 60 + 300 = 460, payment = 460)

Документација
Тест Случај 1 осигурува дека функцијата правилно се справува со null влез за листата на ставки.
Тест Случај 2 проверува како функцијата се однесува со празна листа, осигурувајќи дека може да го обработи ова без проблеми.
Тест Случај 3 тестира сценарио каде името на ставка е null и треба да се постави на "unknown".
Тест Случај 4 верифицира дека функцијата правилно ги идентификува и обработува невалидните карактери во баркодот.
Тест Случај 5 проверува како функцијата реагира на ставка со null баркод.
Тест Случај 6 тестира примена на попуст за ставки со цена до 300.
Тест Случај 7 верифицира специјалното правило за попуст за ставки со цена над 300 и баркод почнувајќи со '0'.
Тест Случај 8 осигурува дека ставки без попуст но со висока цена се правилно собрани.
Тест Случај 9 тестира комбинација на ставки со различни услови за да се осигура вкупната точност на функцијата.

### Тест случаи според критериумот Every path

Комбинации на Вредности
item.getPrice() > 300	item.getDiscount() > 0	item.getBarcode().charAt(0) == '0'	
Очекуван резултат
T	T	T	T
T	T	F	F
T	F	T	F
T	F	F	F
F	T	T	F
F	T	F	F
F	F	T	F
F	F	F	F
Тест Случаи
Тест Случај 1: Сите услови се точни (T, T, T)

Влез: allItems = [new Item("Item1", "012345", 400, 0.1)], payment = 370
Очекувано: true (sum = 400 * 0.1 = 40, sum + 400 = 440, 440 - 30 = 410, payment = 410)
Тест Случај 2: Првите два услови се точни, третиот е неточен (T, T, F)

Влез: allItems = [new Item("Item1", "112345", 400, 0.1)], payment = 440
Очекувано: true (sum = 400 * 0.1 = 40, sum + 400 = 440, payment = 440)
Тест Случај 3: Првиот и третиот услов се точни, вториот е неточен (T, F, T)

Влез: allItems = [new Item("Item1", "012345", 400, 0)], payment = 400
Очекувано: true (sum = 400, payment = 400)
Тест Случај 4: Само првиот услов е точен (T, F, F)

Влез: allItems = [new Item("Item1", "112345", 400, 0)], payment = 400
Очекувано: true (sum = 400, payment = 400)
Тест Случај 5: Вториот и третиот услов се точни, првиот е неточен (F, T, T)

Влез: allItems = [new Item("Item1", "012345", 200, 0.1)], payment = 220
Очекувано: true (sum = 200 * 0.1 = 20, sum + 200 = 220, payment = 220)
Тест Случај 6: Само вториот услов е точен (F, T, F)

Влез: allItems = [new Item("Item1", "112345", 200, 0.1)], payment = 220
Очекувано: true (sum = 200 * 0.1 = 20, sum + 200 = 220, payment = 220)
Тест Случај 7: Првиот и третиот услов се неточен, третиот е точен (F, F, T)

Влез: allItems = [new Item("Item1", "012345", 200, 0)], payment = 200
Очекувано: true (sum = 200, payment = 200)
Тест Случај 8: Сите услови се неточни (F, F, F)

Влез: allItems = [new Item("Item1", "112345", 200, 0)], payment = 200
Очекувано: true (sum = 200, payment = 200)

Документација

Тест Случај 1 осигурува дека попустот од 30 денари се применува кога сите услови се исполнети.
Тест Случај 2 проверува дали попустот од 30 денари не се применува кога баркодот не започнува со '0'.
Тест Случај 3 проверува дали попустот од 30 денари не се применува кога попустот е 0.
Тест Случај 4 проверува дали попустот од 30 денари не се применува кога ниту попустот е > 0 ниту баркодот започнува со '0'.
Тест Случај 5 проверува дали попустот од 30 денари не се применува кога цената на артиклот е <= 300.
Тест Случај 6 проверува дали попустот од 30 денари не се применува кога цената на артиклот е <= 300 и баркодот не започнува со '0'.
Тест Случај 7 проверува дали попустот од 30 денари не се применува кога цената на артиклот е <= 300 и попустот е 0.
Тест Случај 8 проверува дали попустот од 30 денари не се применува кога ниту еден од условите не е исполнет.


