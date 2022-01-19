package com.general;

import java.util.ArrayDeque;
import java.util.Deque;

public class Text0071 {

    public static String simplifyPath(String path) {

        String[] paths = path.split("/");
        Deque<String> stack  = new ArrayDeque<>();
        for (int i = 1; i < paths.length; i++) {
            switch (paths[i]){
                case ".":
                case "":
                    break;
                case "..":
                    if(stack.size() > 0) {
                        stack.pop();
                    }
                    break;
                default:
                    stack.push(paths[i]);
            }
        }
        StringBuilder new_path = new StringBuilder();
        while (!stack.isEmpty()) {
            new_path.append("/")
                    .append(stack.pollLast());
        }
        if (new_path.length() == 0) {
            new_path.append("/");
        }
        return new_path.toString();
    }

    public static void main(String[] args) {
        String path = "/home//foo/";
        System.out.println("path = " + path);
        System.out.println("simplifyPath(path) = " + simplifyPath(path));

    }


}
