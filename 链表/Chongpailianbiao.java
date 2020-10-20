package 链表;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/*
给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
 */

public class Chongpailianbiao {
    public void reorderList(ListNode head) {
        if(head == null) return;
        List<ListNode> list = new ArrayList<>();

        while(head != null) {  //将链表储存在list里
            list.add(head);
            head = head.next;
        }

        int i = 0;
        int j = list.size() - 1;
        //首一个尾一个依次取
        while(i < j) {
            list.get(i).next = list.get(j);
            i++;

            if(i == j) break;

            list.get(j).next = list.get(i);
            j--;
        }
        list.get(i).next = null;

    }
}
