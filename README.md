!!! choiceSignature поправить номер элемента подписи или сделать выбор по названию
# Смоук-тест ЕРКНМ
С помощью данного проекта производится смоук тестирование ЕРКНМ.

Условия запуска:
* JDK 13
* IDEA
* КриптоПро CSP
* КриптоПро Плагин
* Как минимум одна ЭП, установленная через КриптоПро CSP 
* Для подтверждения подписания КНМ без участия пользователя необходимо добавить сайт в список доверенных 
узлов Крипто-Про. Для этого используется приложение Настройки Крипто-Про ЭЦП Browser Plug-in
* У учетных записей supervisor и prosecutor должна быть добавлена организация *(10000001127) Федеральная служба по надзору в сфере здравоохранения*, Связанные организации *Генеральная прокуратура*, 

Инструкция по запуску:
* Открыть проект в IDEA
* В resources/data.xml:
  - в тегах user указать правильные пароли для supervisor, prosecutorm ombudsman, admin
  - в теге information аттрибуту ИНН задать такой ИНН, который найдётся в elasticSearch
* В файле testPages.Common у переменной url задать нужный стенд (demo, dev, test)
* ПКМ нажать на файл bvt.xml и нажать Run
* При выполнении тестов не использовать ПК, так как может не установиться плагин КриптоПро
* Иногда могут быть ошибки, которые возникают из-за медлительности сайта. В таком случае лучше перезапустить тест

Список кейсов:

* Общие разделы
  - Авторизация
  - Проверка изменения раздела при переключении режимов ЕРКНМ и ЕРП
* Личный кабинет
  - Создание шаблона обязательных требований
  - Редактирование шаблона обязательных требований
  - Удаление шаблона обязательных требований
  - Создание шаблона проверочных листов
  - Редактирование шаблона проверочных листов
  - Удаление шаблона проверочных листов
  - Создание уполномоченного на проведение КНМ
  - Редактирование уполномоченного на проведение КНМ
  - Удаление уполномоченного на проведение КНМ
* Список проверок ЕРП
  - Добавление проверки (статус в процессе формирования)
  - Перевод проверки в статус в процессе проведения
  - Перевод проверки в статус завершено
  - Удаление проверки
  - Добавление ранее созданных шаблонов в паспорт проверки
* Список планов ЕРП
  - Создание плана (Статус Новый)
  - Перевод плана в статус На согласовании
  - Перевод плана в статус На доработке
  - Перевод плана в статус Согласован
  - Перевод плана в статус Утвержден
  - Удаление плана
* Поиск проверок ЕРП
  - Проверка работоспособности поиска КНМ
* Новости ЕРП
  - Добавление новости
  - Редактирование новости
  - Удаление новости
* Список проверок ЕРКНМ
  - Создание внеплановой КНМ требующей согласования (статус В процессе заполнения)
  - Создание шаблонов обязательных требований (для ЕРКНМ)
  - Перевод КНМ в статус В процессе заполнения -> Готово к согласованию
  - Перевод КНМ в статус Готово к согласованию -> На согласовании
  - Перевод КНМ в статус На согласовании -> Ожидает завершения
  - Перевод КНМ в статус На согласовании -> Ожидает проведения
  - Перевод КНМ в статус Ожидает завершения -> Завершено
  - Перевод КНМ в статус На согласовании -> Не согласована
  - Удаление КНМ
  - Создание КНМ с созданием шаблона проверочных листов (статус В процессе заполнения)
  - Добавление уполномоченных на проведение проверки (статус В процессе заполнения)
* Список планов ЕРКНМ
  - Создание плана (статус в процессе формирования)
  - Добавление плановой КНМ в созданный план
  - Перевод плана в статус На рассмотрении
  - Перевод плана в статус Рассмотрен
  - Перевод плана в статус Утвержден
  - Исключение КНМ из плана в статусе Утвержден
  - Удаление плана
* Список ПМ
  - Создание ПМ, вид Объявление предостережения, статус В процессе заполнения
  - Перевод Объявление предостережения в статус В процессе заполнения -> Предостережение объявлено
  - Перевод Объявление предостережения в статус В процессе заполнения -> Есть возражение
  - Создание ПМ, вид Профилактический визит, статус В процессе заполнения
  - Перевод Профилактического визита в статус В процессе заполнения -> Ожидает проведения
  - Перевод Профилактического визита в статус Ожидает проведения -> Завершено
  - Перевод Профилактического визита в статус Ожидает проведения -> отказ в проведении
  - Удаление ПМ
* Новости ЕРКНМ
  - Добавление новости
  - Редактирование новости
  - Удаление новости
* Поиск мероприятий ЕРКНМ
  - Проверка работоспособности поиска КНМ
  - Проверка работоспособности поиска ПМ
