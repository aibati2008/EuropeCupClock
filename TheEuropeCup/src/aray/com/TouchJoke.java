package aray.com;

import java.util.Random;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.*;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class TouchJoke extends Activity implements OnClickListener {
    /** Called when the activity is first created. */
	private static String[] joke = new String[] { "虽然希腊扳平了比分，但波兰并不慌乱，这就是人们常说的波兰不惊 ","高考数学最后一道大题：为什么几乎每届世界杯欧洲杯都有球员赶上过生日？而且生日当天总有一场重要的比赛？而且过生日的球员往往能在这场比赛中打进关键进球帮助球队取胜/出线/夺冠？请运用学过的数学知识（比如概率）综合分析原因 ","奔驰的足球场上，裁判忽然向某个球员出示一张黄牌，正在大家惋惜时，他忽然把另一张黄牌也出示了出来。大家纷纷表示不解，裁判淡然一笑,深藏功与名：一张黄牌也没用，如果让他得到完整的两张，还可以换成一张红牌，何乐而不为呢。场上顿时响起了雷鸣般的掌声。 "," 欧洲杯比赛的看台上，球迷们自发组成了各种各样的方块队，为自己国家的球队呐喊助威。俄罗斯球迷见状，也组成了一个方块队，然后……就全部消失了。"," 把欧洲杯和NBA总决赛安排在中国大学的考试月，是欧美发达国家的一场阴谋，妄图以此提高大学生挂科率，打击一代人的信心，阻碍中国的发展。希望大学老师们以国家利益为重，明辨是非，酌情给分。","很难理解解说员把范巴斯縢简称为范巴滕，这就像把范玮琪说成范伟一样。 "," 一个女球迷因车祸受伤而不能视物，眼看欧洲杯期间不能看球心急如焚，于是无数次的向上帝祷告。终于上帝来到她的耳边对她说“Tell me what you want！”“See Cup of Europe !”上帝听完打量了一下她后笑道“ok”，然后女球迷就成了C罩杯……"," 赛后记者采访意大利主帅普兰德利，问道为什么换下巴洛特里时，普兰德利愤怒的指责了拉莫斯：拉莫斯一开赛就问了巴洛特里一个问题，导致巴洛特里一直在思考这个问题，没法集中精神在比赛上。记者好奇的问：什么问题？普兰德利：什么样的节奏是最呀最摇摆，什么样的歌声才是最开怀？"," 西班牙队接受采访时表示，意大利队中他们最害怕的人是巴洛特利，因为根本猜不出他拿球之后会干什么。意大利队员们急忙说：我们也是！"," 厄齐尔回传科恩特朗，科恩特朗直传赫迪拉，赫迪拉本想过顶传给前插的C罗，突然发现不大对劲，这是欧洲杯不是联赛，要保守一些，于是回传给了佩佩...德国主帅勒夫和葡萄牙主帅本托满脸黑线站在场边大吼：分清敌我！场上五人同时大喊：皇马万岁！打倒拜仁！...德国及葡萄牙其余人等泪流满面..."," 今年NBA季后赛趋势我已经发现了，第一轮动物什么的死光光，就好像灰熊、小牛、公牛、老鹰什么的，第二第三轮人类死玩，比如湖人、76人、凯尔特人、步行者！最后剩下来的，靠！大自然的决战，雷霆打热火。总结：还是大自然的力量最强大 ！！！"," 邵佳一欧洲杯首轮预测全错。网友回复：配上青花瓷的副歌曲调：意大利有托蒂，法国有亨利，中国有邵佳一，预测赛贝利............真唱出来了","布冯深情地看着托雷斯满眼都是阿毛里的影子... ","T9专注解围30年，自信源自专业",
		" 俄罗斯在一场比赛中攻破切赫把守的大门的次数，比拜仁巴萨三场比赛加起来都多……阿尔沙文在比赛三十分钟的触球次数，比他在阿森纳的半个赛季都要多……"," 英格兰国家队日前拜访了波兰一家孤儿院。“那一张张毫无朝气与希望的脸，真是让人心碎啊。”一名6岁的孤儿如是说道。","从前，每当小贝为英格兰进球时，全英所有的骚年第二天都会上街剃个小贝的发型。问题是，现在，为英格兰进球的是莱斯科特…… ","一句话,回应离开阿森纳传闻,范佩西以国家队表现示忠心... "
		};
	TextView textView;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);       
        setContentView(R.layout.joke);
        setTitle("没品笑话");
        Button button0 = (Button) findViewById(R.id.button0);
        textView=(TextView) findViewById(R.id.textview0);
        textView.setMovementMethod(ScrollingMovementMethod.getInstance());
		button0.setOnClickListener(this);
        
    }
    


	@Override
	public void onClick(View arg0) {
		Random rnd = new Random();
		String s=joke[rnd.nextInt(joke.length)];
	   textView.setText(s);
		// TODO Auto-generated method stub
		
	}
}