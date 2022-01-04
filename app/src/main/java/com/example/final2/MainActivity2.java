package com.example.final2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    private Button back;
    private ImageView picture;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        ListView listview = (ListView) findViewById(R.id.list_step);
        TextView name = (TextView) findViewById(R.id.meal_name);

        findViews();
        String[] chinesemeat =
               {"1.準備食材，清理與清洗之。",
                "2.老薑切片，青蔥切長段，辣椒與蒜頭不切。",
                "3.用快力鍋，開小火，放入少許油，熱鍋後，放入豬肉(皮先朝下)煎。",
                "4.將6個面都煎至恰恰上色。",
                "5.將煎好的肉放入鍋內，加入蒜頭，薑片，辣椒，蔥白。",
                "6.加入所有的調味料，加入水。(水位不可超過鍋子2/3刻度，避免危險)。",
                "7.以中火烹煮(約煮10分鐘)，立刻轉小火，計時20分鐘，時間到關火。",
                "8.開蓋後，加入蔥綠，試味道，鹹淡可由鹽或醬油及糖作調整即可。",
                "9.筍乾要先清洗泡水或汆燙去除鹹與酸味，完成後取適量的步驟。",
                "10.滷汁與筍乾另鍋滷煮約15分鐘，完成筍乾。",
                "11.筍乾擺於盤底或邊緣，再舀入滷好的大封肉(可依個人喜愛再撒上香菜或蔥花)即可上桌。"};

        String[] chinesevegetable =
                {"小提示:1、食譜中指的1大匙=15ml ,1茶匙=5ml。\n" +
                        "2、櫻花蝦為個人喜好，可省略亦可改為蝦米 (請事先炒熟)。\n" +
                        "3、高麗菜及紅蘿蔔請切細絲，避免餅皮已熟而蔬菜不熟。\n" +
                        "4、翻面後不加蓋，可使餅皮保持酥脆口感。",
                        "1.將高麗菜切成絲；紅蘿蔔去皮切成絲；其它材料備齊。",
                        "2.將所有麵糊材料拌勻備用。",
                        "3.將所有食材與作法2的麵糊攪拌均勻。",
                        "4.不鏽鋼平底鍋倒入1大匙油，中大火加熱約90秒(形成不沾效果)後，倒入作法3的麵糊鋪平蓋上鍋蓋，小火煎約6~7分鐘後翻面。",
                        "5.翻面後開蓋小火續煎6~7分鐘，至二面皆呈金黃香酥即可起鍋。"};

        String[] chinesegarlicshirmp =
                {"1、蒜頭剝皮切碎（勿拍打，一定要用切的）。",
                        "2、冬粉泡水半小時備用。",
                        "3、胭脂蝦洗淨、處理好，跟冬粉一起擺盤。",
                        "4、冷鍋下豬油，開小火、蒜頭放入鍋用小火炒出香味。",
                        "5、關火（避免蒜頭燒焦），加入醬油膏、米酒與水，開小火慢炒均勻。",
                        "6、將炒好的蒜蓉醬鋪在已經擺好盤的蝦子上，上鍋子蒸，水滾後蒸約七分鐘。",
                        "7、七分鐘後，打開鍋蓋，放入蔥花，關火、上鍋蓋悶20秒即可(這裡可以改潑油，關火放入蔥花，將燒熱的香油淋上，會更香）。"};

        String[] chinesesoup =
                {"小提示:1、蓮子不需先浸泡，否則會沒辦法煮到熟軟，保證像彈珠一樣滾來滾去\n" +
                        "2、如果使用的是乾貨干貝，加米酒蓋過干貝，再放入電鍋蒸一杯水時間即可\n" +
                        "3、快速泡發乾香菇、紅棗、蝦米的方式，就是直接用滾燙的熱水浸泡10分鐘，超級省時唷\n",
                        "1、烤箱400度F預熱，芋頭切滾刀塊備用，將蒜頭、鳥蛋、排骨、雞翅用醬油、酒醃10分鐘。",
                        "2、取出排骨裹上地瓜粉，跟芋頭、蒜頭、雞翅、鳥蛋一起排在烤盤中，再刷上一點油，400度F烤15分鐘。",
                        "3、起油鍋，爆香蔥段、蝦米、扁魚、香菇，再注入高湯、蓮子、紅棗燒開，中火煮10分鐘，再加糖、米酒、鹽調味。",
                        "4、將大白菜和杏鮑菇墊底，依序放上雞翅、芋頭、蓮子、排骨、香菇、蒜頭、紅棗、鳥蛋、金鉤蝦、干貝。",
                        "5、注入高湯到滿，用錫箔紙密封，電鍋蒸1小時。",
                        "6、400度F、烤20分鐘，所有食材都呈現金黃色澤。",
                        "7、七分鐘後，打開鍋蓋，放入蔥花，關火、上鍋蓋悶20秒即可(這裡可以改潑油，關火放入蔥花，將燒熱的香油淋上，會更香）。"};

//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        String[] redmeat =
               {"1、準備1根胡蘿蔔，2根芹菜，半個洋蔥，把它們洗淨後都切成小塊，取烤盤，先在烤盤上刷一層油，再平鋪上三種蔬菜，\n" +
                       "烤箱預熱到225度，放入烤盤烘烤約20分鐘，然後取出，取來湯鍋，注入 1.5 升的清水，放入烤過的蔬菜，打火煮開，\n" +
                       "煮開後放入一小片香葉，再撒少許白胡椒粉，攪勻後轉小火，煮約1個小時，就先叫它蔬菜高湯吧。",
                "2、一個小時後關火，取濾網，過濾出無雜質的蔬菜高湯，過濾的時候可以一手拿濾網，一手拿小湯匙，\n" +
                        "邊過濾邊用湯匙按壓蔬菜，以過濾出更多的湯汁。",
                "3.牛肉洗淨，切成大塊，然後用廚房用紙吸去表面的水分，取平底鍋，倒入一大湯匙橄欖油，\n" +
                        "依次放入牛肉塊，中小火煎至金黃色，煎好後放入湯鍋中。",
                "4.把盛有牛肉的小鍋放到火上，倒入80C.C.紅酒，中火加熱，直至煮乾，中間別忘了時常拌炒一下。",
                "5.這時倒入之前做好的蔬菜高湯，加入兩大匙罐裝番茄醬，攪勻。",
                "6.還需要加一點培根，最好不省略培根，把培根放入小鍋內煎香，再放到牛肉鍋裡一起煮，\n" +
                        "在放番茄醬的時候一起加入就可以了，除此之外別忘了再加一片香葉，大火煮開後轉小火，蓋上鍋蓋煮上 2.5 - 3 個小時。\n" +
                        "還需要準備一些蔬菜，有胡蘿蔔、馬鈴薯、洋蔥、蘑菇，把它們洗淨後都切成大塊，蔬菜在最後 30-40 分鐘時放入。",
                "7.兩個多小時後，放入胡蘿蔔塊，洋蔥塊，馬鈴薯塊(馬鈴薯切好後直接放入就行了，不必用水沖洗，這樣湯汁濃稠得更好吃)",
                "8.放入這三樣蔬菜後先煮一會，然後再放入蘑菇。蔬菜和蘑菇都放入後，就可以加鹽和黑胡椒碎調味了，黑胡椒碎也最好別省略。",
                "9.煮到馬鈴薯和胡蘿蔔變軟就可以關火了，這時湯汁也收得恰到好處了。做好的牛肉可以搭配米飯或麵食，非常好吃。"};

        String[] potato =
                {"1、準備材料，洋蔥切碎，魚肉洗淨控乾表面水份。",
                        "2、在鱈魚的兩面均勻地撒上鹽和胡椒粉再擠上幾滴檸檬汁，醃製10分鐘。",
                        "3.醃好的鱈魚放在打好的蛋液中先均勻的裹上一層再兩面都沾上杏仁片",
                        "4.平底鍋燒熱將橄欖油燒至5成熱時，放入魚片，用中小火煎至二面金黃",
                        "5.放在鋪了錫紙的烤盤上放入預熱好180度的烤箱中烤10分鐘左右。",
                        "6.做白葡萄酒酥油汁：平底鍋中加入白葡萄酒加入洋蔥碎，小火煮開慢慢少量多次的加入酥油，\n" +
                                "用攪拌器朝一個方向攪拌，直至酥油全部吸收湯汁變稠即可澆在烤好的鱈魚上一起吃。"};

        String[] fish =
                {"小提示:1、鱈魚的質量影響著菜的成敗，好的鱈魚肉應該凝而不散，質量差的鱈魚會容易散掉。\n" +
                        "2、鱈魚在醃製之前要將魚表面的水份控乾，可用廚房紙在魚身上輕輕按壓吸去水份。\n",
                        "1、準備材料，洋蔥切碎，魚肉洗淨控乾表面水份。",
                        "2、在鱈魚的兩面均勻地撒上鹽和胡椒粉再擠上幾滴檸檬汁，醃製10分鐘。",
                        "3.醃好的鱈魚放在打好的蛋液中先均勻的裹上一層再兩面都沾上杏仁片",
                        "4.平底鍋燒熱將橄欖油燒至5成熱時，放入魚片，用中小火煎至二面金黃",
                        "5.放在鋪了錫紙的烤盤上放入預熱好180度的烤箱中烤10分鐘左右。",
                        "6.做白葡萄酒酥油汁：平底鍋中加入白葡萄酒加入洋蔥碎，小火煮開慢慢少量多次的加入酥油，\n" +
                                "用攪拌器朝一個方向攪拌，直至酥油全部吸收湯汁變稠即可澆在烤好的鱈魚上一起吃。"};

        String[] soup =
                {"1.先來煮牛肉吧，把買來的牛肉洗淨，切成小塊，放到湯鍋裡，注入適量的清水，放到火上大火煮滾，撇去浮沫，\n" +
                        "改小火燜至牛肉軟爛，看看時間，兩個小時以後就可以了~ 燉牛肉的時候我只點了幾滴料酒，\n" +
                        "臨關火前加了點鹽調味，其他什麼調料都沒放~ 如果家裡有紅茶包的話，可以丟一個下去，可以讓牛肉更容易酥爛。",
                        "2.將青菜、馬鈴薯、胡蘿蔔洗淨去皮切小塊，洋蔥、捲心菜、紅腸切片，番茄去皮切小塊，芹菜洗淨切小塊，切的時候大小最好一致，\n" +
                                "如果你是剛剛才燉的牛肉，那青菜要等到牛肉燉好後再切。",
                        "3.取來另一個鍋，放入奶油，溶化後放入馬鈴薯塊，隨後放入紅腸，待香味都出來了，\n" +
                                "放入其他蔬菜，再放入番茄醬，加入少許的鹽調一下味，翻炒均勻後趁熱全部倒入剛剛燉好的牛肉湯鍋中，用小火繼續煮燉~",
                        "4.在快燉好的時候還要炒一下麵粉，將麵粉倒入乾淨的炒鍋中，用小火將麵粉炒至微黃，其間要不停的攪拌，\n" +
                                "然後趁熱加到正在煮燉的紅菜湯裡，用湯勺攪拌均勻，加入的多少看你自己的喜好，希望濃稠些可以多放一點，不放也可以",
                        "5.最後再煮上一會，待裡面的蔬菜都軟爛了就可以了，關火前加入鹽，糖，胡椒粉攪勻就可以吃了。"};
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        String[] re_meat =
                       {"1.把雞胸肉平鋪在保鮮膜上，並將雞胸肉拍扁。",
                        "2.灑上少許的黑胡椒、鹽巴，並放上一匙的大蒜醬。",
                        "3.將雞肉從各個方向往中間包，並利用保鮮膜將雞肉捲起來成一個球狀後，丟進冷凍庫，冰30分鐘。\n" +
                                "(冰的動作是要讓雞肉定型，如果省略內餡的奶油很可能會流出來，所以冰的動作非常重要。)",
                        "4.30分鐘後從冰箱取出雞胸肉，然後依需沾裹(1)麵粉、(2)蛋液、(3)麵包粉。",
                        "5.沾裹後的雞肉再一次放進冷凍庫，冰15分鐘。",
                        "6.起油鍋，加熱至約180度後下鍋油炸60秒，60秒後翻面，再炸60秒，起鍋後直接放入烤箱，用攝氏180度，烤12分鐘。\n" +
                                "(1.如果是使用小烤箱一定要覆蓋鋁箔紙，以免雞胸肉烤焦；2.烘烤的時間會依照雞胸的厚度、大小的不同而有所增減。)",
                        "7.烤好以後裝盤，放上自己喜歡的配菜就完成了，一刀切開，保證香味四溢。"};
        String[] re_soup =
                       {"1.食材先準備好，如果沒有剌山柑，可用青碗豆取代，將洋蔥、肉、火腿、義大利香腸和酸黃瓜切成條狀或切丁。",
                        "2.倒入大約一半(500ml)的水到小鍋子裡，以大火煮滾。當水滾後，轉成小火。將香料放入小鍋中，以小火繼續溫煮。",
                        "3.同時，準備一個大約3公升的鍋子。大火熱鍋後，將洋蔥和肉放入鍋中爆香。之後，火腿、義大利香腸和蕃茄膏放入鍋中拌炒。",
                        "4.最後，酸黃瓜、刺山柑、檸檬汁、小鍋中的香料水和剩餘的水放入鍋中。如果喜歡吃辣的人，也可以加點辣椒粉",
                        "5.大火滾煮後，蓋上鍋蓋。轉成小火，燉煮30分鐘，之後加入的食材已經有些鹹味，因此關火前，可先試味道，依自己的喜好加鹽或水調味。",
                        "6.上桌前，加一點酸奶油，撒點蒔蘿或香菜做裝飾。"};

        String[] re_veg =
                       {"1.刺瓜、櫻桃蘿蔔拌勻。",
                        "2.馬鈴薯加入步驟1並灑上些許的鹽和胡椒調拌，再拌勻。",
                        "3.冷鍋加入培根、洋蔥以中小火拌炒至洋蔥香味散出。",
                        "4.清水加入，黃芥苿加入並稍微拌勻。",
                        "5.酸奶油加入步驟拌勻成醬汁，調入鹽、胡椒和糖再度拌勻。",
                        "6.洋蔥圓切，並且與半成品拌勻，即可享用。"};

        String[] re_seafood =
                       {"1.魚兩條 - 依喜好選擇魚種\n先將魚清理一翻，把內臟掏出來、魚皮扒開，保留魚骨、魚尾和下魚鰭部位",
                        "2.在鍋子裡把兩隻處理好的魚放入，加入1公升左右的水，開大火直到水滾。\n" +
                                "水滾了之後，放一湯匙的鹽巴，轉小火，蓋上蓋子，煮個25分鐘。",
                        "3.等待煮湯同時，可以先將洋蔥、馬鈴薯切塊、紅蘿蔔刨絲等待。",
                        "4.25分之後，先將魚骨、魚尾等挑掉，接著放入馬鈴薯、紅蘿蔔、洋蔥等食材，接著再放入胡椒粒、胡椒粉、月桂葉、蒔蘿等調味料。",
                        "5.接著再煮個25分鐘就大功告成了"};




        Intent intent = this.getIntent();
        Bundle b = intent.getExtras();
        int kitchen = b.getInt("kitchen");
        int btn_sel = b.getInt("btn_sel");
        int pos = b.getInt("pos");


        switch (kitchen) {
            case 0: {
                switch (btn_sel) {
                    case 0: {
                        switch (pos) {
                            case 0: {
                                name.setText("筍乾封肉");
                                ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, chinesemeat);
                                listview.setAdapter(adapter);
                                secondImage.setImageResource(R.drawable.chinesemeat);
                                break;
                            }
                            case 1: {
                                name.setText("高麗菜煎餅");
                                ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, chinesevegetable);
                                listview.setAdapter(adapter);
                                secondImage.setImageResource(R.drawable.chinesevegetable);
                                break;
                            }
                            case 2: {
                                name.setText("蒜蓉蒸蝦");
                                ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, chinesegarlicshirmp);
                                listview.setAdapter(adapter);
                                secondImage.setImageResource(R.drawable.chinesegarlicshirmp);
                                break;
                            }
                            case 3: {
                                name.setText("佛跳牆");
                                ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, chinesesoup);
                                listview.setAdapter(adapter);
                                secondImage.setImageResource(R.drawable.chinesesoup);
                                break;
                            }
                        }
                        break;
                    }

                    case 1: {
                        switch (pos) {
                            case 0: {
                                name.setText("筍乾封肉");
                                ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, chinesemeat);
                                listview.setAdapter(adapter);
                                secondImage.setImageResource(R.drawable.chinesemeat);
                                break;
                            }
                            case 1: {
                                name.setText("高麗菜煎餅");
                                ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, chinesevegetable);
                                listview.setAdapter(adapter);
                                secondImage.setImageResource(R.drawable.chinesevegetable);
                                break;
                            }
                            case 2: {
                                name.setText("佛跳牆");
                                ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, chinesesoup);
                                listview.setAdapter(adapter);
                                secondImage.setImageResource(R.drawable.chinesesoup);
                                break;
                            }
                        }
                        break;
                    }
                    case 2: {
                        switch (pos) {
                            case 0: {
                                name.setText("高麗菜煎餅");
                                ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, chinesevegetable);
                                listview.setAdapter(adapter);
                                secondImage.setImageResource(R.drawable.chinesevegetable);
                                break;
                            }
                            case 1: {
                                name.setText("佛跳牆");
                                ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, chinesesoup);
                                listview.setAdapter(adapter);
                                secondImage.setImageResource(R.drawable.chinesesoup);
                                break;
                            }
                        }
                        break;
                    }
                    case 3: {
                        switch (pos) {
                            case 0: {
                                name.setText("佛跳牆");
                                ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, chinesesoup);
                                listview.setAdapter(adapter);
                                secondImage.setImageResource(R.drawable.chinesesoup);
                                break;
                            }
                        }
                        break;
                    }
                    case 4: {
                        switch (pos) {
                            case 0: {
                                name.setText("蒜蓉蒸蝦");
                                ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, chinesegarlicshirmp);
                                listview.setAdapter(adapter);
                                secondImage.setImageResource(R.drawable.chinesegarlicshirmp);
                                break;
                            }
                        }
                        break;
                    }
                }
                break;
            }
            case 1: {
                switch (btn_sel) {
                    case 0: {
                        switch (pos) {
                            case 0: {
                                name.setText("紅酒燉牛肉");
                                ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, redmeat);
                                listview.setAdapter(adapter);
                                secondImage.setImageResource(R.drawable.redmeat);
                                break;
                            }
                            case 1: {
                                name.setText("馬鈴薯球");
                                ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, potato);
                                listview.setAdapter(adapter);
                                secondImage.setImageResource(R.drawable.potato);
                                break;
                            }
                            case 2: {
                                name.setText("香煎杏仁鱈魚");
                                ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, fish);
                                listview.setAdapter(adapter);
                                secondImage.setImageResource(R.drawable.fish);
                                break;
                            }
                            case 3: {
                                name.setText("羅宋湯");
                                ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, soup);
                                listview.setAdapter(adapter);
                                secondImage.setImageResource(R.drawable.soup);
                                break;
                            }
                        }
                        break;
                    }

                    case 1: {
                        switch (pos) {
                            case 0: {
                                name.setText("紅酒燉牛肉");
                                ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, redmeat);
                                listview.setAdapter(adapter);
                                secondImage.setImageResource(R.drawable.redmeat);
                                break;
                            }
                        }
                        break;
                    }
                    case 2: {
                        switch (pos) {
                            case 0: {
                                name.setText("馬鈴薯球");
                                ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, potato);
                                listview.setAdapter(adapter);
                                secondImage.setImageResource(R.drawable.potato);
                                break;
                            }
                        }
                        break;
                    }
                    case 3: {
                        switch (pos) {
                            case 0: {
                                name.setText("羅宋湯");
                                ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, soup);
                                listview.setAdapter(adapter);
                                secondImage.setImageResource(R.drawable.soup);
                                break;
                            }
                        }
                        break;
                    }
                    case 4: {
                        switch (pos) {
                            case 0: {
                                name.setText("香煎杏仁鱈魚");
                                ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, fish);
                                listview.setAdapter(adapter);
                                secondImage.setImageResource(R.drawable.fish);
                                break;
                            }
                        }
                        break;
                    }
                }
                break;
            }
            case 2: {
                switch (btn_sel) {
                    case 0: {
                        switch (pos) {
                            case 0: {
                                name.setText("基輔雞");
                                ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, re_meat);
                                listview.setAdapter(adapter);
                                secondImage.setImageResource(R.drawable.re_meat);
                                break;
                            }
                            case 1: {
                                name.setText("雜拌湯");
                                ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, re_soup);
                                listview.setAdapter(adapter);
                                secondImage.setImageResource(R.drawable.re_soup);
                                break;
                            }
                            case 2: {
                                name.setText("馬鈴薯沙拉菜");
                                ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, re_veg);
                                listview.setAdapter(adapter);
                                secondImage.setImageResource(R.drawable.re_veg);
                                break;
                            }
                            case 3: {
                                name.setText("烏哈湯");
                                ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, re_seafood);
                                listview.setAdapter(adapter);
                                secondImage.setImageResource(R.drawable.re_seafood);
                                break;
                            }
                        }
                        break;
                    }

                    case 1: {
                        switch (pos) {
                            case 0: {
                                name.setText("基輔雞肉");
                                ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, re_meat);
                                listview.setAdapter(adapter);
                                secondImage.setImageResource(R.drawable.re_meat);
                                break;
                            }
                        }
                        break;
                    }
                    case 2: {
                        switch (pos) {
                            case 0: {
                                name.setText("馬鈴薯沙拉菜");
                                ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, re_veg);
                                listview.setAdapter(adapter);
                                secondImage.setImageResource(R.drawable.re_veg);
                                break;
                            }
                        }
                        break;
                    }
                    case 3: {
                        switch (pos) {
                            case 0: {
                                name.setText("雜拌湯");
                                ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, re_soup);
                                listview.setAdapter(adapter);
                                secondImage.setImageResource(R.drawable.re_soup);
                                break;
                            }
                            case 1: {
                                name.setText("烏哈湯");
                                ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, re_seafood);
                                listview.setAdapter(adapter);
                                secondImage.setImageResource(R.drawable.re_seafood);
                                break;
                            }
                        }
                        break;
                    }
                    case 4: {
                        switch (pos) {
                            case 0: {
                                name.setText("烏哈湯");
                                ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, re_seafood);
                                listview.setAdapter(adapter);
                                secondImage.setImageResource(R.drawable.re_seafood);
                                break;
                            }
                        }
                        break;
                    }
                }
                break;

            }
        }

        back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
    private ImageView secondImage;
    private void findViews() {
        secondImage = (ImageView) findViewById(R.id.picture);
    }
}