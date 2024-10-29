package com.github.affandes.kuliah.pm;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private final ArrayList<String> history;

    public Main() {
        history = new ArrayList<>();
    }

    public void view() {
        if (history.isEmpty()) {
            System.out.println("History browser kosong.");
        } else {
            System.out.println("History Browser:");
            for (int i = history.size() - 1; i >= 0; i--) {
                System.out.println((i + 1) + ". " + history.get(i));
            }
        }
    }

    public void browse(String url) {
        history.add(url);
        System.out.println("Menambahkan ke history: " + url);
    }

    public void back() {
        if (history.isEmpty()) {
            System.out.println("Tidak ada history untuk dihapus.");
        } else {
            String lastVisited = history.remove(history.size() - 1);
            System.out.println("Kembali dari: " + lastVisited);
        }
    }

    public static void main(String[] args) {
        Main browserHistory = new Main();
        Scanner scanner = new Scanner(System.in);
        String command;

        System.out.println("Simulasi History Browser");
        do {
            System.out.println("\nPerintah:");
            System.out.println("1. view - Tampilkan history");
            System.out.println("2. browse [url] - Tambahkan website ke history");
            System.out.println("3. back - Kembali ke website sebelumnya");
            System.out.println("4. exit - Keluar dari program");
            System.out.print("Masukkan perintah: ");
            command = scanner.nextLine();

            if (command.startsWith("2")) {
                String url = command.substring(2);
                browserHistory.browse(url);
            } else if (command.equals("1")) {
                browserHistory.view();
            } else if (command.equals("3")) {
                browserHistory.back();
            } else if (!command.equals("4")) {
                System.out.println("Perintah tidak valid.");
            }
        } while (!command.equals("exit"));

        System.out.println("Keluar dari program.");
        scanner.close();
    }
}
