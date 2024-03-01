# Кастомные крафты

Данный плагин добавить на ваш сервер [Nukkit-MOT](https://github.com/MemoriesOfTime/Nukkit-MOT) кастомые крафты с
демонстрацией рецептов в виртуальном сундуке.

Механика данного плагина разрешает вам выполнить сразу несколько автоматических действий, что делает его максимально
удобным в использовании.

### - [Видео](https://dygers.fun/images/demo/customcraft.mp4)

### Команды
/newcraft - Открывает инвентарь с демонстрацией рецептов

### Регистрация крафта

Логика регистрации крафта аналогична встроенной механики [ShapedRecipe](https://github.com/MemoriesOfTime/Nukkit-MOT/blob/master/src/main/java/cn/nukkit/inventory/ShapedRecipe.java)

```
new CustomShapedRecipe(Item.get(ItemID.SPYGLASS), new String[]{
                        "ISI",
                        "G G",
                        "GSG"
                }, new HashMap<>(){{
                    put('I', Item.get(Item.IRON_INGOT));
                    put('G', Item.get(Item.GOLD_INGOT));
                    put('S', Item.get(Item.GLASS_PANE));
                }}),
```

## TODO
- Добавить пагинацию