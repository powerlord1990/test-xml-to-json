### Тестовое задание "Джейсон Иксэмэл"

Разработать web-приложение, позволяющее загружать xml-файл на сервер и выводить в формате json.

### Общие требования

1. Приложение должно быть реализовано на Java 8 или выше с использованием [Java Servlet API](https://docs.oracle.com/javaee/7/tutorial/servlets.htm).
   Допускается использование любого фреймворка/платформы/библиотеки работающего поверх Java Servlet API.
1. Приложение должно запускаться на сервере приложений [Tomcat](https://tomcat.apache.org/) 8 или выше.
1. Для описания сборки приложения использовать любую из современных систем
   автоматической сборки: [gradle](https://gradle.org/), [maven](https://maven.apache.org/) и др.
1. Выполненное задание необходимо отправить на wannajavajob@i-novus.ru.
1. Ориентировочный срок выполнения - 5 дней.

### Web-формы

Приложение должно содержать 2 формы:

1. форму, через которую можно загрузить файл на сервер,
1. форму, где можно увидеть результат загрузки.

Допускается обе формы разместить на одной странице.

Пример того, как может выглядеть страница:

![Пример формы](test-job-example-form.png)

### Параметры загружаемых файлов

1. Валидный файл формата xml.
1. Значения узлов в xml строковые, но могут содержать числа как подстроку. Числа могут быть как дробные, так и целые.

**Допускается вводить свои дополнительные ограничения на входящие файлы, если не получается сделать универсальный вариант.**
Конечно, чем меньше ограничений будет добавлено, тем лучше. В идеале - не добавлять совсем.

Серьезным плюсом будет возможность обработки больших входящих файлов, размером до 10Гб.

### Формат вывода

Нужно вывести загруженный xml в виде дерева в формате json. Иерархию(дерево) узлов исходного xml нужно сохранить и перенести в json.
Исходные значения узлов переносить не нужно. Вместо этого в каждый узел иерархии нужно добавить дочерний элемент `"value"`, значение которого должно быть равно сумме всех целых чисел, которые встретились в значениях этого узла и всех его дочерних узлов.
Если в узле не встретились числа, то элемент `"value"` должен иметь значение `"0"`.

### Пример
На входе:
```xml
<root>
 <nodeA>Node 1</nodeA>
 <nodeB>
  <nodeC>Node 2</nodeC>
  <nodeD>Node 3</nodeD>
 </nodeB>
</root>
```

На выходе:
```json
{
  "root": {
    "value": "6",
    "nodeA": { "value": "1" },
    "nodeB": {
      "value": "5",
      "nodeC": { "value": "2" },
      "nodeD": { "value": "3" }
    }
  }
}
```

### Критерии оценки
Оцениваться будет всё, начная от codestyle, заканчивая скоростью работы приложения и выбранным способом решения. Например, плюсом будет наличие юнит-тестов.
Приветствуются свои оригинальные решения, не приветствуется копипаста с чужих готовых проектов.