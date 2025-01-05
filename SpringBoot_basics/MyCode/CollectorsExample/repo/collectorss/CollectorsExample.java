package repo.collectorss;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class CollectorsExample {
    public static void main(String[] args) {
        BlogPost b1 = new BlogPost("title","Aravinth",BlogPostType.NEWS,10);
        BlogPost b4 = new BlogPost("title3","Sundu",BlogPostType.NEWS,50);
        BlogPost b2 = new BlogPost("title1","Sundu",BlogPostType.GUIDE,20);
        BlogPost b3 = new BlogPost("title1","Aravinth",BlogPostType.REVIEW,30);
        List<BlogPost> posts = Arrays.asList(b1,b2,b3,b4);
        System.out.println("--------groupingBy(BlogPost::getType) ----------");
        Map<BlogPostType, List<BlogPost>> postsPerType = posts.stream().sorted(Comparator.comparing(BlogPost::getTitle))
                .collect(groupingBy(BlogPost::getType));
        postsPerType.entrySet().forEach(System.out::println);
    System.out.println("--------new Tuple(post.getType(), post.getAuthor()) ----------");
        Map<Tuple, List<BlogPost>> postsPerTypeAndAuthor = posts.stream()
                .collect(groupingBy(post -> new Tuple(post.getType(), post.getAuthor())));
        postsPerTypeAndAuthor.entrySet().forEach(System.out::println);

        System.out.println("--------records instead of tuple ----------");
        Map<BlogPost.AuthPostTypesLikes, List<BlogPost>> postsPerTypeAndAuthor1 = posts.stream()
                .collect(groupingBy(post -> new BlogPost.AuthPostTypesLikes(post.getAuthor(), post.getType(), post.getLikes())));
        postsPerTypeAndAuthor1.entrySet().forEach(System.out::println);

        System.out.println("--------Modifying the Returned Map Value Type ----------");
        Map<BlogPostType, Set<BlogPost>> postsPerType1 = posts.stream()
                .collect(groupingBy(BlogPost::getType, toSet()));
        postsPerType1.entrySet().forEach(System.out::println);

        System.out.println("---------To group the List of BlogPosts first by author and then by type: ----------");
        Map<String, Map<BlogPostType, List<BlogPost>>> map = posts.stream()
                .collect(groupingBy(BlogPost::getAuthor, groupingBy(BlogPost::getType)));
        map.entrySet().forEach(System.out::println);

        System.out.println("---------to find the average number of likes for each blog post type:----------");
        Map<BlogPostType, Double> averageLikesPerType = posts.stream()
                .collect(groupingBy(BlogPost::getType, Collectors.averagingInt(BlogPost::getLikes)));
        averageLikesPerType.entrySet().forEach(System.out::println);

        System.out.println("---------to calculate the total sum of likes for each type::----------");
        Map<BlogPostType, Integer> likesPerType = posts.stream()
                .collect(groupingBy(BlogPost::getType, Collectors.summingInt(BlogPost::getLikes)));
        likesPerType.entrySet().forEach(System.out::println);

        System.out.println("---------to calculate the total sum of likes for each type::----------");
        Map<BlogPostType, Optional<BlogPost>> maxLikesPerPostType = posts.stream()
                .collect(groupingBy(BlogPost::getType,
                        maxBy(Comparator.comparingInt(BlogPost::getLikes))));
        maxLikesPerPostType.forEach((key, value) -> System.out.println(key + " = " + value.get()));

        System.out.println("---------Let’s calculate a summary for the likes attribute of the blog posts for each different type:::----------");
        Map<BlogPostType, IntSummaryStatistics> likeStatisticsPerType = posts.stream()
                .collect(groupingBy(BlogPost::getType,
                        summarizingInt(BlogPost::getLikes)));
        likeStatisticsPerType.entrySet().forEach(System.out::println);

        Map<String, BlogPost.PostCountTitlesLikesStats> postsPerAuthor = posts.stream()
                .collect(groupingBy(BlogPost::getAuthor, collectingAndThen(toList(), list -> {
                    long count = list.stream()
                            .map(BlogPost::getTitle)
                            .count();
                    String titless = list.stream()
                            .map(BlogPost::getTitle)
                            .collect(joining(" : "));
                    IntSummaryStatistics summary = list.stream()
                            .collect(summarizingInt(BlogPost::getLikes));
                    return new BlogPost.PostCountTitlesLikesStats(count, titless, summary);
                })
                ));

        postsPerAuthor.entrySet().forEach(System.out::println);

        Blog blog1 = new Blog("1", "Nice", "Very Nice");
        Blog blog2 = new Blog("2", "Disappointing", "Ok", "Could be better");
        List<Blog> blogs = List.of(blog1, blog2);

        Map<String,  List<List<String>>> authorComments1 = blogs.stream()
                .collect(Collectors.groupingBy(Blog::getAuthorName,
                        Collectors.mapping(Blog::getComments, Collectors.toList())));
        authorComments1.entrySet().forEach(System.out::println);

        Map<String, List<String>> authorComments2 = blogs.stream()
                .collect(Collectors.groupingBy(Blog::getAuthorName,
                        Collectors.flatMapping(blog->blog.getComments().stream(),
                                Collectors.toList())));
        authorComments2.entrySet().forEach(System.out::println);
       /* Blog blog =new Blog();
        String ss =null;
        String sss ="";
        System.out.println(sss.isEmpty());
         Optional.ofNullable(blog.getAuthorName()).ifPresent(System.out::println);
        Optional<Object> optional = null;
        System.out.println(optional);
        Supplier<Optional<String>> s = "supplier"::describeConstable;
        String source =  Optional.ofNullable(ss).orElse("NAPCVC");
        System.out.println("Source : "+source);
        System.out.println(Optional.ofNullable("").get());
        Optional<String> source1 =  Optional.ofNullable(ss).or(s);
        System.out.println(source1.get());*/


    }


}
