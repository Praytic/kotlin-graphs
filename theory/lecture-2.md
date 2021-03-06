# Прикладные задачи теории графов. 
###Часть 1.

__Пример 1__. Социальные сети. Теория графов в игре престолов. Вершины - персонажи. Ребра - диалоги. (см. слайд "Алгоритмы на графе").  
__Пример 2__. Реконструкция генома.  
__Пример 3__. Веб-граф.  
__Пример 4__. Алгоритм PageRank.  
__Пример 5__. Граф дорог.  
__Пример 6__. Дерево решений. Банковское дело. Промышленность. Медицина. Молекулярная биология.

###Часть 2.

I. __Нахождение минимальных путей__. Есть n городов и для некоторых пар городов известна цена билета. Нужно найти кратчаший 
путь (в плане данной меры). Есть алгоритм от выделенной вершины до всех остальных Форда-Беллмана, Дейкстры, Флоида 
(ищет между всеми парами вершин) и алгоритм поиска пути в бесформленном графе. 
  
II. __Размещение центров, покрывающих заданную область__. Размещение военных баз, контроллирующих данную территорию. 
Размещение центров торговли, обслуживающих данный район. Вышки сотовой связи. Задача: требуется разместить радиопередающие 
станции на территории, разделенные на 16 районов. Известно, что станции расположены в любом из районов охватывает данный 
район и соседний по горизонтали и вертикали. Нужно разместить минимальное кол-во станций, чтобы они охватили все квадраты. 
Решение: строится граф, вершины которого соотвествуют району и 2 вершины связаны ребром тогда и только тогда, когда
соответствующие районы - соседние. После этого задача сводится к нахождению наименьшего (число вершин минимально) 
доминирующего множества вершин графа (подмножество вершин графа {x}, такое, что любая вершина x' смежна с какой-то вершиной из {x}).
 
 III. __Прокладка линий связи минимальной стоимости__. Постановка задачи: дано n объектов с известными расстояниями (стоимостями)
 между ними. Необходимо построить сеть, связывающую эти точки так, чтобы длина этой сети и ее суммарная стоимость была минимальной.
 Строится взвешенный граф, вершинам которого соответствуют заданные объекты, а ребра - дороги между ними, а веса - расстояния.
 Мы должны построить кратчайшее оставное дерево (каркас минимального веса, стягивающее дерево минимального веса). Дерево -
 это связный граф не содержащий циклов. Алгоритмы решения: алгоритм Краскала, Прима и Борувки.
 
 Д/З. Посмотреть презентации и опредилиться с докладами. 