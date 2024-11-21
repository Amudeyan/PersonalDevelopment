package repo;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class WindowSliding {

    public static void main(String[] args) {
        int[] input = new int[]{34,323,4,343,3,23,232,323,23,23,245,66,7,7,87};
       // Arrays.stream(input).
        Optional<String> val;
        Optional.ofNullable("Str").ifPresentOrElse(System.out::println,
                ()-> {
            throw new RuntimeException();
        });
       List<double[]> names = Arrays.asList(new double[]{12, 32, 21}, new double[]{3, 4, 45, 5, 65});
      names.stream().flatMapToDouble(Arrays::stream).forEach(System.out::println);
        //System.out.println(count);

        //int co  =  names.stream().max(Comparator.comparing(String::length)).get().length();
        //System.out.println(co);
        Transaction transaction = new Transaction("Monday",343434343);
        Transaction transaction1 = new Transaction("Monday",434343434);
        Transaction transaction2 = new Transaction("Monday",34343434);
        Transaction transaction3 = new Transaction("Monday",34343434);
        Transaction transaction4 = new Transaction("Tuesday",34343434);
        Transaction transaction5 = new Transaction("Tuesday",34343434);
        Transaction transaction6 = new Transaction("Sunday",34343434);
        List<Transaction> trans = Arrays.asList(transaction,transaction1,transaction2,transaction3,transaction4,transaction5,transaction6);
        Map<String, Long> map = trans.stream().collect(Collectors.groupingBy(Transaction::getDays,Collectors.summingLong(Transaction::getAmount)));

        map.forEach((k,v)-> System.out.println(k +":"+v));

        int k =20;
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6);
        
        //Map.Entry<String,List<Transaction> > maps = (Map.Entry<String, List<Transaction>>) map.entrySet().;

    }

    static class Transaction{
        private String days;
        private int amount;

        public Transaction(String days, int amount) {
            this.days = days;
            this.amount = amount;
        }

        public String getDays() {
            return days;
        }

        public void setDays(String days) {
            this.days = days;
        }

        public int getAmount() {
            return amount;
        }

        public void setAmount(int amount) {
            this.amount = amount;
        }

        @Override
        public String toString() {
            return "Transaction{" +
                    "days='" + days + '\'' +
                    ", amount='" + amount + '\'' +
                    '}';
        }
    }



}
