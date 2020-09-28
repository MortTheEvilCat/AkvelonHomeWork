package com.example.greekhoroscope.mvp.repository;

import android.content.Context;

import com.example.greekhoroscope.db.HoroDataBase;
import com.example.greekhoroscope.db.dao.HoroDao;
import com.example.greekhoroscope.db.entity.HoroEntity;
import com.example.greekhoroscope.mvp.contract.HoroContract;

import java.util.LinkedList;
import java.util.List;

public class HoroRepository implements HoroContract.Repository {
    private HoroDataBase mDataBase;
    private HoroDao mHoroDao;

    private List<HoroEntity> mCache;

    private static HoroRepository sInstance;

    public static HoroRepository getInstance(Context context) {
        if (sInstance == null) {
            sInstance = new HoroRepository(context);
        }

        return sInstance;
    }

    @Override
    public List<HoroEntity> loadEntities() {
        if (mCache == null) {
            mCache = mHoroDao.getAll();
        }
        return mCache;
    }

    @Override
    public List<HoroEntity> loadFavouriteEntities() {
        return mHoroDao.getFavourites();
    }

    @Override
    public void updateEntity(HoroEntity entity) {
        mHoroDao.update(entity);
    }

    private HoroRepository(Context context) {
        mDataBase = HoroDataBase.getInstance(context);
        mHoroDao = mDataBase.horoDao();

        initDB();
    }

    private void initDB() {
        List<HoroEntity> initList = new LinkedList<>();
        HoroEntity e1 = new HoroEntity();
        e1.name = "Aries";
        e1.description = "You’re a fire sign who’s always ready for whatever challenges life brings, and this year is no different. Step up and conquer the world!\n" +
                "\n" +
                "You feed off the fast-paced energy from your dynamic power planet Mars and 2020 starts with this aggressive planet in Sagittarius, the sign of adventure and knowledge. World travel now is an amazingly eye-opening experience now, rich with valuable learning experiences. It will take another several months, until the end of June, until Mars reaches its most dominant placement in your sign, where it will stay for the next two months. Winning is your main objective and yes, you can be a sore loser!";

        initList.add(e1);

        HoroEntity e2 = new HoroEntity();
        e2.name = "Taurus";
        e2.description = "Your love of the good life motivates you to accomplish some great things this year!\n" +
                "\n" +
                "Venus, goddess of love and money, is your ruler and as she starts the year out in experimental Aquarius (Venus in Pisces January 1), your mind opens to new ideas in both areas. You’re more comfortable, though, when she enters your sign in early March until early April and then again in Libra (the other signs she rules) for about three weeks at the end of October. Pleasure and passion combine now to help you enjoy the finer things in life. The one retrograde period your ruler experiences is from mid-May to end of June, during her trip through curious Gemini, causing you to ponder the dualities of love and money. While you can’t imagine living life without a lot of either, it’s interesting to consider the alternatives.";
        initList.add(e2);

        HoroEntity e3 = new HoroEntity();
        e3.name = "Gemini";
        e3.description = "Connect with yourself and others on a higher level this year.\n" +
                "\n" +
                "Mercury is your ever-logical, perceptive ruler, and as one of the fastest moving planets it changes signs quickly. It seems like everyone’s on the lookout for Mercury’s dreaded retrograde cycles, and because it’s your ruler, you should pay extra close attention. Not that you’re going to let them slow you down too much, but this year the three periods between February 6 and March 9, June 17 and July 11, and October 13 and November 2 are all dates to be aware of. It’s also important to note that all three retrogrades pass through emotional water signs, which advise you to slow down when dealing with the obstacles like miscommunications, misunderstandings and commuting mishaps. This will be challenging for you, Gemini, but you can do it.";
        initList.add(e3);

        HoroEntity e4 = new HoroEntity();
        e4.name = "Cancer";
        e4.description = "Make yourself a top priority this year.\n" +
                "\n" +
                "Your sign is linked with your roller coaster emotions, so it makes sense that your ruler is the emotional moon. Paying close attention to the moon’s movements will help you understand your moodiness a little better this year, starting with a full moon/lunar eclipse in your sign in the middle of January. You may feel lasting effects of this lunation as it is closely tied to family relationships, especially parent-child. Reunions and healing can take place now but be careful not to fall back into the same old unhealthy dynamics you’ve been trying to escape once the happiness subsides.";
        initList.add(e4);

        HoroEntity e5 = new HoroEntity();
        e5.name = "Leo";
        e5.description = "Be the best Lion you can be in 2020!\n" +
                "\n" +
                "You love basking in attention so it’s only fitting that your ruler is the ego-boosting sun. When 2020 begins the sun is in earthy, responsible Capricorn, so you’ll find yourself doing things for the sense of accomplish more than the glory. That all changes by the end of July, however, when the sun moves into your flashy sign and welcomes in your birthday month. Happy birthday expressive, creative Leo! Your mood is outgoing and playful, and you crave strong reactions to your antics. For the next four weeks you’re the life of the party, and you add the color and drama that’s been missing from your loved ones’ lives.\n";
        initList.add(e5);

        HoroEntity e6 = new HoroEntity();
        e6.name = "Virgo";
        e6.description = "Take care of your mind and body this year!\n" +
                "\n" +
                "Your ruler, Mercury, is one of the fastest moving planets, so your mind is naturally quick and alert. This year Mercury begins in practical, kindred earth sign Capricorn and quickly forms a conjunction with mind-expanding Jupiter, setting an optimistic tone for the year. Feeling broad-minded and sociable is a great way to start 2020.";
        initList.add(e6);

        HoroEntity e7 = new HoroEntity();
        e7.name = "Libra";
        e7.description = "Your sense of fairness drives you to success.\n" +
                "\n" +
                "Your lovely home planet, Venus, begins the year in airy Aquarius but quickly moves into sensitive, compassionate Pisces in the middle of January. This comfortable pairing creates a romantic, dreamy flow of love that will help you be more understanding, forgiving and affectionate. Venus travels through your sign starting at the end of October, putting close relationships in the spotlight. Don’t let your willingness to negotiate with people lead to crippling indecisiveness.";
        initList.add(e7);

        HoroEntity e8 = new HoroEntity();
        e8.name = "Scorpio";
        e8.description = "Nothing shakes your confidence this year!\n" +
                "\n" +
                "You’ve got that infamous Scorpio swagger already, but you’ll really be feeling yourself when your power planet, Mars, spends time in your sign at the very beginning of the year. A couple days later Mars moves on to adventurous, knowledge-seeking Sagittarius, but for those first two days you’re untouchable! Mars in Aries, the other sign it rules, packs another great punch when they team up at the end of June, but it could also cause you to be impatient and self-centered, which aren’t two inherent Scorpio qualities";
        initList.add(e8);

        HoroEntity e9 = new HoroEntity();
        e9.name = "Sagittarius";
        e9.description = "If you can envision it, you can make it a reality.\n" +
                "\n" +
                "As the fiery Archer, your outgoing, adventurous nature is backed by your power planet, optimistic Jupiter. This year, Jupiter is paired up with serious Capricorn again, so the mood still isn’t that light. Your good luck is directly tied to your actions this year, essentially ensuring that you make your own luck by working hard and actively shaping your own future. A retrograde period from the middle of May to mid-September gives you a chance to review your goals, and reconsider some of your opinions/ideals. If you’re on the right track, forge ahead. But if you’ve been wrong, admit it and change direction.";
        initList.add(e9);

        HoroEntity e10 = new HoroEntity();
        e10.name = "Capricorn";
        e10.description = "Combine the old with the new to be more successful this year.\n" +
                "Your home planet Saturn arrived in your practical sign back in December of 2017 and continues that trip for part of this year as well. You should be especially focused on your goals now and may be particularly in tune with your ultimate purpose in life. You must be willing to make changes to meet your full potential, but a hardworking Goat is never afraid to do whatever it takes to climb to the top. Development and progress in all areas of life are possible this year if you focus on yourself and what’s most important.";
        initList.add(e10);

        HoroEntity e11 = new HoroEntity();
        e11.name = "Aquarius";
        e11.description = "The new year is full of changes and challenges!\n" +
                "\n" +
                "Your home planet, Uranus, made a big move into steady Taurus last year, and these two very different energies aren’t the best of friends. Uranus is experimental and Taurus likes to take a conservative approach, so there will be some mismatched energy to deal with now. The retrograde period for your power planet this year is from mid-August until the end of the year, which should give you a slight break from the need for outward rebellion. Turning that rebellious streak inward, however, can create its own set of issues, so be prepared for inner battles that can lead you down the path to self-destruction (and ultimately redemption) this year.";
        initList.add(e11);

        HoroEntity e12 = new HoroEntity();
        e12.name = "Pisces";
        e12.description = "A mix of illusion and reality shapes your year.\n" +
                "\n" +
                "Your home planet Neptune supports your idealistic approach to life, and because it’s traveling in your escapist sign all year, this is the time to really dream big. Pay attention to intuition and visions – your subconscious is an accurate window into your soul and what you truly want this year.";
        initList.add(e12);

        mHoroDao.insertAll(initList);
    }
}
