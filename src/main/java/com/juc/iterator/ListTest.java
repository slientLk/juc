package com.juc.iterator;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 如果只有一份，写的时候为了线程安全加锁，读线程读到这个list的时候就要等写线程释放锁
 * （跟数据库一样，一张表数据很多，你执行了一个复杂的更新语句，那么整个表被锁，所有查询
 * 都要等到更新完毕后才可以执行，一个复杂关联查询耗时较长，该表处于锁定状态，其他写操作
 * sql就必须等到该查询执行完毕才可以执行），如果在主库上写，在从库上读，读操作和写操作
 * 的锁不会彼此影响。CopyOnWriteArrayList既要保证线程安全，又要保证读的速度快，复
 * 制出来一份供写操作使用，读操作一份，各自操作无论什么时候读，读不存在等待其他线程释放
 * 锁的时间，自然就快了。你看下java.uril.HashTable,读写操作的一份数据，读写方法都加
 * 锁，写速度可能比CopyOnWriteArrayList 快，读的速度肯定没法和CopyOnWriteArrayList 比。
 */
// java.util.ConcurrentModificationException 并发修改异常！
public class ListTest {

    public static void main(String[] args) {
        // 并发下 ArrayList 不安全的吗，Synchronized；
        /**
         * 解决方案；
         * 1、List<String> list = new Vector<>();
         * 2、List<String> list = Collections.synchronizedList(new ArrayList<>());
         * 3、List<String> list = new CopyOnWriteArrayList<>()；
         */
        // CopyOnWrite 写入时复制  COW  计算机程序设计领域的一种优化策略；
        // 读写分离
        // CopyOnWriteArrayList  比 Vector Nb 在哪里？

//        List<String> list = new ArrayList<>();
        List<String> list = new CopyOnWriteArrayList<>();

        for (int i = 1; i <= 10; i++) {
            new Thread(() -> {
                list.add(UUID.randomUUID().toString().substring(0,5));
                System.out.println(list);
            },String.valueOf(i)).start();
        }
    }
}
