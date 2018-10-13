package kyu6;

public class Dubstep
{
    public static void main(String[] args)
    {
        System.out.println(
                songDecoder("WUBWEWUBAREWUBWUBTHEWUBCHAMPIONSWUBMYWUBFRIENDWUB")); // =>  WE ARE THE CHAMPIONS MY FRIEND
        System.out.println(songDecoder("WUBWUBABCWUB")); // =>  ABC
        System.out.println(songDecoder("RWUBWUBWUBLWUB")); // =>  R L
    }

    public static String songDecoder(String song)
    {
        return song.replaceAll("(WUB)+", " ").trim();
    }
}