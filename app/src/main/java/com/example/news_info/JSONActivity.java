package com.example.news_info;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.news_info.bean.InfoBean;
import com.example.news_info.bean.InfoText;
import com.example.news_info.bean.JSONBean;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JSONActivity extends AppCompatActivity {

    private static final String TAG = "JSONActivity";

    private TextView mTextView;

    //获取json数据
    String json = "{\n" +
            "    \"data\": {\n" +
            "        \"count\": 5,\n" +
            "        \"items\": [\n" +
            "            {\n" +
            "                \"id\": 45,\n" +
            "                \"title\": \"坚果\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"id\": 132,\n" +
            "                \"title\": \"炒货\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"id\": 166,\n" +
            "                \"title\": \"蜜饯\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"id\": 195,\n" +
            "                \"title\": \"果脯\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"id\": 196,\n" +
            "                \"title\": \"礼盒\"\n" +
            "            }\n" +
            "        ]\n" +
            "    },\n" +
            "    \"rs_code\": \"1000\",\n" +
            "    \"rs_msg\": \"success\"\n" +
            "}";


//    private String json = "{\"a\":\"100\",\n" +
//            "\"b\":[{\"b1\":\"b_value1\",\"b2\":\"b_value2\"},\n" +
//            "{\"b1\":\"b_value1\",\"b2\":\"b_value2\"}]，\n" +
//            "\"c\":{\"c1\":\"c_value1\",\"c2\":\"c_value2\"}}";

private String s = "{\"reason\":\"success!\",\"result\":{\"stat\":\"1\",\"data\":[{\"uniquekey\":\"94b5bad65dfe378a2c894f7221fee026\",\"title\":\"警惕！“爱心助农”新诈骗 杭州有人被骗数万元\",\"date\":\"2022-08-08 15:59:00\",\"category\":\"头条\",\"author_name\":\"杭州网，供稿：人民资讯\",\"url\":\"https:\\/\\/mini.eastday.com\\/mobile\\/220808155939059441023.html\",\"thumbnail_pic_s\":\"\",\"is_content\":\"1\"},{\"uniquekey\":\"0df93933ca5124df89e11212f44ca000\",\"title\":\"太原公交电车分公司四车队多措并举应对降雨天气\",\"date\":\"2022-08-08 15:59:00\",\"category\":\"头条\",\"author_name\":\"太原日报，供稿：人民资讯\",\"url\":\"https:\\/\\/mini.eastday.com\\/mobile\\/220808155904763803390.html\",\"thumbnail_pic_s\":\"https:\\/\\/dfzximg02.dftoutiao.com\\/news\\/20220808\\/20220808155904_3e456be1994d5a2b60a91d135a0c3528_1_mwpm_03201609.jpeg\",\"is_content\":\"1\"},{\"uniquekey\":\"d6a627e2d525a6319204dac1a7772b94\",\"title\":\"提醒！新华区持续“阳光”发放丧葬补助金\",\"date\":\"2022-08-08 15:59:00\",\"category\":\"头条\",\"author_name\":\"平顶山日报，供稿：人民资讯\",\"url\":\"https:\\/\\/mini.eastday.com\\/mobile\\/220808155904657150409.html\",\"thumbnail_pic_s\":\"\",\"is_content\":\"1\"},{\"uniquekey\":\"8456672f9959fdacba001763b5ae0671\",\"title\":\"婚车司机该吃盒饭还是酒席？小夫妻办婚礼，新娘怒了：道歉\",\"date\":\"2022-08-08 15:59:00\",\"category\":\"头条\",\"author_name\":\"大洋网，供稿：人民资讯\",\"url\":\"https:\\/\\/mini.eastday.com\\/mobile\\/220808155904221171703.html\",\"thumbnail_pic_s\":\"https:\\/\\/dfzximg02.dftoutiao.com\\/news\\/20220808\\/20220808155904_720faea96691c24c2e85c4ff75cdbf9a_1_mwpm_03201609.jpeg\",\"thumbnail_pic_s02\":\"https:\\/\\/dfzximg02.dftoutiao.com\\/news\\/20220808\\/20220808155904_720faea96691c24c2e85c4ff75cdbf9a_2_mwpm_03201609.jpeg\",\"thumbnail_pic_s03\":\"https:\\/\\/dfzximg02.dftoutiao.com\\/news\\/20220808\\/20220808155904_720faea96691c24c2e85c4ff75cdbf9a_3_mwpm_03201609.jpeg\",\"is_content\":\"1\"},{\"uniquekey\":\"ca2015af7fac55fc15ee252f555fb078\",\"title\":\"金飞路林贤路：半挂车起火 现场浓烟滚滚\",\"date\":\"2022-08-08 15:58:00\",\"category\":\"头条\",\"author_name\":\"新民晚报，供稿：人民资讯\",\"url\":\"https:\\/\\/mini.eastday.com\\/mobile\\/220808155829567422495.html\",\"thumbnail_pic_s\":\"https:\\/\\/dfzximg02.dftoutiao.com\\/news\\/20220808\\/20220808155829_4ab8bc9e14f93ecd86db2b1f306b33de_1_mwpm_03201609.jpeg\",\"is_content\":\"1\"},{\"uniquekey\":\"e40afe0642a17ecc0466d015209425f0\",\"title\":\"高速“搭车”要不得，勿用生命走“捷径”\",\"date\":\"2022-08-08 15:57:00\",\"category\":\"头条\",\"author_name\":\"吉林日报，供稿：人民资讯\",\"url\":\"https:\\/\\/mini.eastday.com\\/mobile\\/220808155719939606110.html\",\"thumbnail_pic_s\":\"https:\\/\\/dfzximg02.dftoutiao.com\\/news\\/20220808\\/20220808155719_b6afd336f543bc1cc7932dcec6724c92_1_mwpm_03201609.jpeg\",\"is_content\":\"1\"},{\"uniquekey\":\"803a13ada2806707de5d7a394434dd85\",\"title\":\"杭州90后帅小伙相亲迟到20分钟，他的理由女方没法拒绝！网友：这小伙能处…\",\"date\":\"2022-08-08 15:56:00\",\"category\":\"头条\",\"author_name\":\"杭州日报，供稿：人民资讯\",\"url\":\"https:\\/\\/mini.eastday.com\\/mobile\\/220808155644400863204.html\",\"thumbnail_pic_s\":\"https:\\/\\/dfzximg02.dftoutiao.com\\/news\\/20220808\\/20220808155644_3fc8704d3ef21cd5d333b4bff82cc869_1_mwpm_03201609.jpeg\",\"thumbnail_pic_s02\":\"https:\\/\\/dfzximg02.dftoutiao.com\\/news\\/20220808\\/20220808155644_3fc8704d3ef21cd5d333b4bff82cc869_2_mwpm_03201609.jpeg\",\"thumbnail_pic_s03\":\"https:\\/\\/dfzximg02.dftoutiao.com\\/news\\/20220808\\/20220808155644_3fc8704d3ef21cd5d333b4bff82cc869_3_mwpm_03201609.jpeg\",\"is_content\":\"1\"},{\"uniquekey\":\"e719a65216b059e5a7a9cc610a4175b4\",\"title\":\"情系防疫一线 菏泽暖心“第一书记”多方筹集防疫物资\",\"date\":\"2022-08-08 15:56:00\",\"category\":\"头条\",\"author_name\":\"中国山东网，供稿：人民资讯\",\"url\":\"https:\\/\\/mini.eastday.com\\/mobile\\/220808155644295708813.html\",\"thumbnail_pic_s\":\"https:\\/\\/dfzximg02.dftoutiao.com\\/news\\/20220808\\/20220808155644_59872f36a022c0a6b771e9dd1bd73aed_1_mwpm_03201609.jpeg\",\"thumbnail_pic_s02\":\"https:\\/\\/dfzximg02.dftoutiao.com\\/news\\/20220808\\/20220808155644_59872f36a022c0a6b771e9dd1bd73aed_2_mwpm_03201609.jpeg\",\"thumbnail_pic_s03\":\"https:\\/\\/dfzximg02.dftoutiao.com\\/news\\/20220808\\/20220808155644_59872f36a022c0a6b771e9dd1bd73aed_3_mwpm_03201609.jpeg\",\"is_content\":\"1\"},{\"uniquekey\":\"1862f7893c519c7e1a3fd546207554a4\",\"title\":\"长春市这家医院被罚！原因是……\",\"date\":\"2022-08-08 15:56:00\",\"category\":\"头条\",\"author_name\":\"北青网，供稿：人民资讯\",\"url\":\"https:\\/\\/mini.eastday.com\\/mobile\\/220808155644095723420.html\",\"thumbnail_pic_s\":\"https:\\/\\/dfzximg02.dftoutiao.com\\/news\\/20220808\\/20220808155644_5ee1266abc5d7f29fb5902159f63eead_1_mwpm_03201609.jpeg\",\"thumbnail_pic_s02\":\"https:\\/\\/dfzximg02.dftoutiao.com\\/news\\/20220808\\/20220808155644_5ee1266abc5d7f29fb5902159f63eead_2_mwpm_03201609.jpeg\",\"is_content\":\"1\"},{\"uniquekey\":\"1ea42d47ed91ae59e991d09413322ae4\",\"title\":\"爱心企业助力菏泽开发区佃户屯街道抗疫工作\",\"date\":\"2022-08-08 15:56:00\",\"category\":\"头条\",\"author_name\":\"中国山东网，供稿：人民资讯\",\"url\":\"https:\\/\\/mini.eastday.com\\/mobile\\/220808155644023142231.html\",\"thumbnail_pic_s\":\"https:\\/\\/dfzximg02.dftoutiao.com\\/news\\/20220808\\/20220808155644_f20222b64d87eaf3f9c74bbd92078dc3_1_mwpm_03201609.jpeg\",\"is_content\":\"1\"},{\"uniquekey\":\"114b6891b132587618972b7a9a9735a3\",\"title\":\"吉林发现4人核酸阳性\",\"date\":\"2022-08-08 15:56:00\",\"category\":\"头条\",\"author_name\":\"光明网，供稿：人民资讯\",\"url\":\"https:\\/\\/mini.eastday.com\\/mobile\\/220808155643884715251.html\",\"thumbnail_pic_s\":\"\",\"is_content\":\"1\"},{\"uniquekey\":\"48433d1d6bd3fc38f58d02d8925fd690\",\"title\":\"争分夺秒！高速交警9分钟紧急护送重症伤员就医\",\"date\":\"2022-08-08 15:56:00\",\"category\":\"头条\",\"author_name\":\"北青网，供稿：人民资讯\",\"url\":\"https:\\/\\/mini.eastday.com\\/mobile\\/220808155643470940309.html\",\"thumbnail_pic_s\":\"https:\\/\\/dfzximg02.dftoutiao.com\\/news\\/20220808\\/20220808155643_1cd714f9f2525e0a10ad3f15584edd12_1_mwpm_03201609.jpeg\",\"is_content\":\"1\"},{\"uniquekey\":\"07fb3f1acaabcf23c5b16e10fd2181a2\",\"title\":\"抚顺市司法鉴定开启网上摇号新模式\",\"date\":\"2022-08-08 15:56:00\",\"category\":\"头条\",\"author_name\":\"东北新闻网，供稿：人民资讯\",\"url\":\"https:\\/\\/mini.eastday.com\\/mobile\\/220808155609171224011.html\",\"thumbnail_pic_s\":\"https:\\/\\/dfzximg02.dftoutiao.com\\/news\\/20220808\\/20220808155609_bc05ffdaa6bb30edd2f25f97a55c0284_1_mwpm_03201609.jpeg\",\"is_content\":\"1\"},{\"uniquekey\":\"b8e1fd2eefe4697af2238149701e5844\",\"title\":\"福彩刮刮乐：添彩百姓生活\",\"date\":\"2022-08-08 15:55:00\",\"category\":\"头条\",\"author_name\":\"人民网－安徽频道，供稿：人民资讯\",\"url\":\"https:\\/\\/mini.eastday.com\\/mobile\\/220808155500733647359.html\",\"thumbnail_pic_s\":\"\",\"is_content\":\"1\"},{\"uniquekey\":\"9786e7f0402f199f76244cf9ccf56aa2\",\"title\":\"高温作业过程中暑，如何进行认定工伤\",\"date\":\"2022-08-08 15:52:00\",\"category\":\"头条\",\"author_name\":\"劳动报，供稿：人民资讯\",\"url\":\"https:\\/\\/mini.eastday.com\\/mobile\\/220808155205168186083.html\",\"thumbnail_pic_s\":\"https:\\/\\/dfzximg02.dftoutiao.com\\/news\\/20220808\\/20220808155205_f32f150f5c526a826950530649501032_1_mwpm_03201609.jpeg\",\"is_content\":\"1\"},{\"uniquekey\":\"9d4d59642e42a13a4e3ba7aae1a7fdaf\",\"title\":\"有人溜进楼道里干坏事！居民一看，气坏了！\",\"date\":\"2022-08-08 15:51:00\",\"category\":\"头条\",\"author_name\":\"光明网，供稿：人民资讯\",\"url\":\"https:\\/\\/mini.eastday.com\\/mobile\\/220808155128480148604.html\",\"thumbnail_pic_s\":\"https:\\/\\/dfzximg02.dftoutiao.com\\/news\\/20220808\\/20220808155128_166a5d4ad061235b52890db790c34721_1_mwpm_03201609.jpeg\",\"thumbnail_pic_s02\":\"https:\\/\\/dfzximg02.dftoutiao.com\\/news\\/20220808\\/20220808155128_166a5d4ad061235b52890db790c34721_2_mwpm_03201609.jpeg\",\"thumbnail_pic_s03\":\"https:\\/\\/dfzximg02.dftoutiao.com\\/news\\/20220808\\/20220808155128_166a5d4ad061235b52890db790c34721_3_mwpm_03201609.jpeg\",\"is_content\":\"1\"},{\"uniquekey\":\"821ccf792e8132c65948be1d21b3896c\",\"title\":\"一片狼藉！两车相撞3万多枚鸡蛋碎一地\",\"date\":\"2022-08-08 15:50:00\",\"category\":\"头条\",\"author_name\":\"光明网，供稿：人民资讯\",\"url\":\"https:\\/\\/mini.eastday.com\\/mobile\\/220808155020336214573.html\",\"thumbnail_pic_s\":\"https:\\/\\/dfzximg02.dftoutiao.com\\/news\\/20220808\\/20220808155020_9856d89a2d35b576e0a048257aea0eae_1_mwpm_03201609.jpeg\",\"thumbnail_pic_s02\":\"https:\\/\\/dfzximg02.dftoutiao.com\\/news\\/20220808\\/20220808155020_9856d89a2d35b576e0a048257aea0eae_2_mwpm_03201609.jpeg\",\"is_content\":\"1\"},{\"uniquekey\":\"ec4e60609c6318ce01571d8cf278f2c3\",\"title\":\"\u200B为让孩子上民办小学，杭州一妈妈被骗20万\",\"date\":\"2022-08-08 15:29:00\",\"category\":\"头条\",\"author_name\":\"杭州日报，供稿：人民资讯\",\"url\":\"https:\\/\\/mini.eastday.com\\/mobile\\/220808152934176485508.html\",\"thumbnail_pic_s\":\"\",\"is_content\":\"1\"},{\"uniquekey\":\"e2850b89ac2930b1247a12dbded84372\",\"title\":\"平顶山发生一起刑事案件！警方悬赏5万元通缉\",\"date\":\"2022-08-08 15:29:00\",\"category\":\"头条\",\"author_name\":\"大河网，供稿：人民资讯\",\"url\":\"https:\\/\\/mini.eastday.com\\/mobile\\/220808152934072636553.html\",\"thumbnail_pic_s\":\"https:\\/\\/dfzximg02.dftoutiao.com\\/news\\/20220808\\/20220808152934_1ecf24874fdd4c61bd614aa47f49aeb1_1_mwpm_03201609.jpeg\",\"thumbnail_pic_s02\":\"https:\\/\\/dfzximg02.dftoutiao.com\\/news\\/20220808\\/20220808152934_1ecf24874fdd4c61bd614aa47f49aeb1_2_mwpm_03201609.jpeg\",\"thumbnail_pic_s03\":\"https:\\/\\/dfzximg02.dftoutiao.com\\/news\\/20220808\\/20220808152934_1ecf24874fdd4c61bd614aa47f49aeb1_3_mwpm_03201609.jpeg\",\"is_content\":\"1\"},{\"uniquekey\":\"75072cd33bda7cc4f30f57faceb96811\",\"title\":\"深夜，石家庄街头光缆被挂断！接下来一幕好暖……\",\"date\":\"2022-08-08 15:28:00\",\"category\":\"头条\",\"author_name\":\"长城网，供稿：人民资讯\",\"url\":\"https:\\/\\/mini.eastday.com\\/mobile\\/220808152825309779483.html\",\"thumbnail_pic_s\":\"https:\\/\\/dfzximg02.dftoutiao.com\\/news\\/20220808\\/20220808152825_45c44b9d5b26e25041b4a03337f73350_1_mwpm_03201609.jpeg\",\"thumbnail_pic_s02\":\"https:\\/\\/dfzximg02.dftoutiao.com\\/news\\/20220808\\/20220808152825_45c44b9d5b26e25041b4a03337f73350_2_mwpm_03201609.jpeg\",\"thumbnail_pic_s03\":\"https:\\/\\/dfzximg02.dftoutiao.com\\/news\\/20220808\\/20220808152825_45c44b9d5b26e25041b4a03337f73350_3_mwpm_03201609.jpeg\",\"is_content\":\"1\"},{\"uniquekey\":\"5bb0aaa5e48d3f8f274d2a9c7f4b2a69\",\"title\":\"男童被反锁商场试衣间，消防上门撬锁解救\",\"date\":\"2022-08-08 15:27:00\",\"category\":\"头条\",\"author_name\":\"半岛都市报，供稿：人民资讯\",\"url\":\"https:\\/\\/mini.eastday.com\\/mobile\\/220808152715937232081.html\",\"thumbnail_pic_s\":\"https:\\/\\/dfzximg02.dftoutiao.com\\/news\\/20220808\\/20220808152715_a3f7dc8188bb5502d5a8ccec70086769_1_mwpm_03201609.jpeg\",\"thumbnail_pic_s02\":\"https:\\/\\/dfzximg02.dftoutiao.com\\/news\\/20220808\\/20220808152715_a3f7dc8188bb5502d5a8ccec70086769_2_mwpm_03201609.jpeg\",\"is_content\":\"1\"},{\"uniquekey\":\"e13bb2f0528beb974dc2c01687a964a3\",\"title\":\"车主注意，借车、挂靠风险大，四种情形发生事故后不能免责\",\"date\":\"2022-08-08 15:26:00\",\"category\":\"头条\",\"author_name\":\"光明网，供稿：人民资讯\",\"url\":\"https:\\/\\/mini.eastday.com\\/mobile\\/220808152642667573015.html\",\"thumbnail_pic_s\":\"\",\"is_content\":\"1\"},{\"uniquekey\":\"566993e255b757d667ac8a02ddbb9b98\",\"title\":\"云南普洱：凹甲陆龟“夜闯民宅”一查竟然是“惯犯”\",\"date\":\"2022-08-08 15:26:00\",\"category\":\"头条\",\"author_name\":\"中国新闻网，供稿：人民资讯\",\"url\":\"https:\\/\\/mini.eastday.com\\/mobile\\/220808152642300353207.html\",\"thumbnail_pic_s\":\"https:\\/\\/dfzximg02.dftoutiao.com\\/news\\/20220808\\/20220808152642_9d542dd786c65e721abee7b5d85e243e_1_mwpm_03201609.jpeg\",\"thumbnail_pic_s02\":\"https:\\/\\/dfzximg02.dftoutiao.com\\/news\\/20220808\\/20220808152642_9d542dd786c65e721abee7b5d85e243e_2_mwpm_03201609.jpeg\",\"is_content\":\"1\"},{\"uniquekey\":\"4e321b495fa27187356e3878f83e172f\",\"title\":\"云南红河警方斩断一偷渡通道 抓获涉案人员119人\",\"date\":\"2022-08-08 15:26:00\",\"category\":\"头条\",\"author_name\":\"中国新闻网，供稿：人民资讯\",\"url\":\"https:\\/\\/mini.eastday.com\\/mobile\\/220808152642001208244.html\",\"thumbnail_pic_s\":\"https:\\/\\/dfzximg02.dftoutiao.com\\/news\\/20220808\\/20220808152642_1962eaa68aaaa5f90617b724c3101a86_1_mwpm_03201609.jpeg\",\"is_content\":\"1\"},{\"uniquekey\":\"b9c7247622addc5c2383917676a032be\",\"title\":\"菏泽移动志愿者：“移”不容辞，志愿同行\",\"date\":\"2022-08-08 15:26:00\",\"category\":\"头条\",\"author_name\":\"中国山东网，供稿：人民资讯\",\"url\":\"https:\\/\\/mini.eastday.com\\/mobile\\/220808152641780536757.html\",\"thumbnail_pic_s\":\"https:\\/\\/dfzximg02.dftoutiao.com\\/news\\/20220808\\/20220808152641_1263fcf427ba71c76491358a2f451bbb_1_mwpm_03201609.jpeg\",\"is_content\":\"1\"},{\"uniquekey\":\"bd2361120ae150be9128873d6e0ff55b\",\"title\":\"云南普洱：凹甲陆龟“夜闯民宅” 一查竟然是“惯犯”\",\"date\":\"2022-08-08 15:26:00\",\"category\":\"头条\",\"author_name\":\"中国新闻网，供稿：人民资讯\",\"url\":\"https:\\/\\/mini.eastday.com\\/mobile\\/220808152641568823184.html\",\"thumbnail_pic_s\":\"https:\\/\\/dfzximg02.dftoutiao.com\\/news\\/20220808\\/20220808152641_8ad532e7e85f509a7c6e01e5e08087e7_1_mwpm_03201609.jpeg\",\"thumbnail_pic_s02\":\"https:\\/\\/dfzximg02.dftoutiao.com\\/news\\/20220808\\/20220808152641_8ad532e7e85f509a7c6e01e5e08087e7_2_mwpm_03201609.jpeg\",\"is_content\":\"1\"},{\"uniquekey\":\"9cf193274d188bb8cbf50134a95565c1\",\"title\":\"车救车结果接连陷入沙滩，即墨消防紧急救援\",\"date\":\"2022-08-08 15:24:00\",\"category\":\"头条\",\"author_name\":\"半岛都市报，供稿：人民资讯\",\"url\":\"https:\\/\\/mini.eastday.com\\/mobile\\/220808152456413670460.html\",\"thumbnail_pic_s\":\"https:\\/\\/dfzximg02.dftoutiao.com\\/news\\/20220808\\/20220808152456_39c34c66ce4df569a52b7bb365549337_1_mwpm_03201609.jpeg\",\"thumbnail_pic_s02\":\"https:\\/\\/dfzximg02.dftoutiao.com\\/news\\/20220808\\/20220808152456_39c34c66ce4df569a52b7bb365549337_2_mwpm_03201609.jpeg\",\"is_content\":\"1\"},{\"uniquekey\":\"e8ac5a4c3e943584f0dc9a9da103ff9c\",\"title\":\"南岸警方打掉一涉案3000余万\\\"杀猪盘\\\"诈骗团伙\",\"date\":\"2022-08-08 15:23:00\",\"category\":\"头条\",\"author_name\":\"人民网－重庆频道，供稿：人民资讯\",\"url\":\"https:\\/\\/mini.eastday.com\\/mobile\\/220808152349360289923.html\",\"thumbnail_pic_s\":\"\",\"is_content\":\"1\"},{\"uniquekey\":\"8f3dd8a8dc8d0dd0868697218591ebf3\",\"title\":\"大祥公安东湖寺派出所铁腕打击一起电信诈骗案\",\"date\":\"2022-08-08 15:16:00\",\"category\":\"头条\",\"author_name\":\"红网，供稿：人民资讯\",\"url\":\"https:\\/\\/mini.eastday.com\\/mobile\\/220808151630005817839.html\",\"thumbnail_pic_s\":\"https:\\/\\/dfzximg02.dftoutiao.com\\/news\\/20220808\\/20220808151630_49c929cbbf83bdf71d66d11c71855746_1_mwpm_03201609.jpeg\",\"is_content\":\"1\"},{\"uniquekey\":\"01ed22839c4181359eaba12e66a34849\",\"title\":\"千里奔袭，邵东警方擒获电诈网上逃犯\",\"date\":\"2022-08-08 15:16:00\",\"category\":\"头条\",\"author_name\":\"红网，供稿：人民资讯\",\"url\":\"https:\\/\\/mini.eastday.com\\/mobile\\/220808151629877659182.html\",\"thumbnail_pic_s\":\"https:\\/\\/dfzximg02.dftoutiao.com\\/news\\/20220808\\/20220808151629_cfaa9165d17e1022a1014823d6bd3de0_1_mwpm_03201609.jpeg\",\"is_content\":\"1\"}],\"page\":\"1\",\"pageSize\":\"30\"},\"error_code\":0}";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json);
        InfoBean infoBean = (new Gson()).fromJson(s, InfoBean.class);
        Log.d(TAG, "onCreate: "+infoBean.getResult().getData().get(0).getTitle());
//        mTextView = findViewById(R.id.json_tv);
//        try {
////            第一层解析
//            JSONObject jsonObject = new JSONObject(json);
//            JSONObject data = jsonObject.optJSONObject("data");
//            int rs_code = jsonObject.optInt("re_code");
//            String rs_msg = jsonObject.optString("rs_msg");
////            第二层解析
//            int count = data.optInt("count");
////            第三层解析
//            JSONArray items = data.optJSONArray("items");
//            ArrayList<HashMap<Integer, String>> result = new ArrayList<>();
//            for (int i = 0; i < items.length(); i++) {
//                JSONObject jsonObject1 = items.optJSONObject(i);
//                if (jsonObject1 != null) {
//                    HashMap<Integer, String> map = new HashMap<>();
//                    int id = jsonObject1.optInt("id");
//                    String title = jsonObject1.optString("title");
//                    map.put(id, title);
//                    result.add(map);
//                }
//            }
//            Log.d(TAG,result.toString());
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//
//
////        将JSON数据封装到JavaBean中
//        try {
//            JSONObject jsonObj = new JSONObject(json);
//            JSONObject data = jsonObj.optJSONObject("data");
//            int re_code = jsonObj.optInt("rs_code");
//            String re_msg = jsonObj.optString("rs_msg");
//            JSONBean  jsonBean = new JSONBean();
//            jsonBean.setRs_code(re_code);
//            jsonBean.setRs_msg(re_msg);
//            JSONBean.DataBean dataBean = new JSONBean.DataBean();
//            jsonBean.setData(dataBean);
//            int count = data.optInt("count");
//            JSONArray items = data.optJSONArray("items");
//            dataBean.setCount(count);
//            List<JSONBean.DataBean.ItemsBean> itemsBeans = new ArrayList<>();
//            dataBean.setItems(itemsBeans);
//            for (int i = 0;i<items.length();i++){
//                JSONObject jsonObject1 = items.optJSONObject(i);
//                if (jsonObject1 != null){
//                    int id = jsonObject1.optInt("id");
//                    String title = jsonObject1.optString("title");
//
//                    //javabean
//                    JSONBean.DataBean.ItemsBean bean = new JSONBean.DataBean.ItemsBean();
//                    bean.setId(id);
//                    bean.setTitle(title);
//                    itemsBeans.add(bean);
//                }
//            }
//        Log.d(TAG,jsonBean.toString());
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }

//        Gson gson = new Gson();
//        Type type = new TypeToken<InfoText>() {
//        }.getType();
//
//        InfoText jsonBean = gson.fromJson(json, type);
////        Log.d(TAG, jsonBean.getA());
////        Log.d(TAG, String.valueOf(jsonBean.getB().get(0)));
////        Log.d(TAG, String.valueOf(jsonBean.getB().get(1)));
////        Log.d(TAG, String.valueOf(jsonBean.getB().get(1)));
////        Log.d(TAG, String.valueOf(jsonBean.getC()));

    }
}
