import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AraYuz {
    private ArrayList<Urun> urunListesi = new ArrayList<>();
    private AlisverisSepeti alisverisSepeti = new AlisverisSepeti();
    private ArrayList<Musteri> musteriListesi = new ArrayList<>();
    private ArrayList<Calisan> calisanListesi = new ArrayList<>();
    private JFrame frame;
    private JPanel panel, topPanel, urunEklePanel, musteriEklePanel,calisanEklePanel;
    private JButton ekleButton, sorgulaButton, silButton, alisverisSepetiButton,
            alisverisListesiButton,musteriEkleButton,calisanEkleButton,musteriListesiButton,calisanListesiButton;
    private JLabel titleLabel;
    private JTable urunTable;
    private JTable musteriTable;
    private JTable calisanTable;


    public AraYuz() {

        ArkaplanPanel arkaplanPanel = new ArkaplanPanel();

        frame = new JFrame("A Market");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(750, 600);


        panel = arkaplanPanel;
        panel.setLayout(new BorderLayout());

        topPanel = new JPanel();
        topPanel.setBackground(Color.BLUE);
        titleLabel = new JLabel("A Market");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(Color.white);
        topPanel.add(titleLabel);
        panel.add(topPanel, BorderLayout.NORTH);









        ekleButton = new JButton("<html><b>Ürün Ekle</b></html>");
        sorgulaButton = new JButton("<html><b>Ürünleri Sorgula</b></html>");
        silButton = new JButton("<html><b>Ürün Sil</b></html>");
        alisverisSepetiButton = new JButton("<html><b>Alışveriş Sepeti</b></html>");
        alisverisListesiButton = new JButton("<html><b>Alışveriş Listesi</b></html>");
        musteriEkleButton = new JButton("<html><b>Müşteri Ekle</b></html>");
        calisanEkleButton = new JButton("<html><b>Çalışan Ekle</b></html>");
        musteriListesiButton = new JButton("<html><b>Müşteri Listesi</b></html>");
        calisanListesiButton = new JButton("<html><b>Çalışan Listesi</b></html>");

        ekleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.removeAll();
                panel.add(topPanel, BorderLayout.NORTH);
                panel.add(eklePanelOlustur(), BorderLayout.CENTER);
                panel.add(buttonPanelOlustur(), BorderLayout.SOUTH);
                frame.revalidate();
                frame.repaint();
            }
        });

        sorgulaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.removeAll();
                panel.add(topPanel, BorderLayout.NORTH);
                panel.add(sorgulaPanelOlustur(), BorderLayout.CENTER);
                panel.add(buttonPanelOlustur(), BorderLayout.SOUTH);
                frame.revalidate();
                frame.repaint();
            }
        });

        silButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                alisverisSepeti.urunSil();
            }
        });

        alisverisSepetiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                urunSepetiEkle();
            }
        });

        alisverisListesiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                urunListesiGoster();
            }
        });
        musteriEkleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.removeAll();
                panel.add(topPanel, BorderLayout.NORTH);
                panel.add(kullaniciEklePanelOlustur(1), BorderLayout.CENTER);
                panel.add(buttonPanelOlustur(), BorderLayout.SOUTH);
                frame.revalidate();
                frame.repaint();
            }
        });
        calisanEkleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.removeAll();
                panel.add(topPanel, BorderLayout.NORTH);
                panel.add(kullaniciEklePanelOlustur(2), BorderLayout.CENTER);
                panel.add(buttonPanelOlustur(), BorderLayout.SOUTH);
                frame.revalidate();
                frame.repaint();
            }
        });
        musteriListesiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.removeAll();
                panel.add(topPanel, BorderLayout.NORTH);
                panel.add(musteriListesiniGoster(), BorderLayout.CENTER);
                panel.add(buttonPanelOlustur(), BorderLayout.SOUTH);
                frame.revalidate();
                frame.repaint();
            }
        });
        musteriListesiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.removeAll();
                panel.add(topPanel, BorderLayout.NORTH);
                panel.add(musteriListesiniGoster(), BorderLayout.CENTER);
                panel.add(buttonPanelOlustur(), BorderLayout.SOUTH);
                frame.revalidate();
                frame.repaint();
            }
        });
        calisanListesiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.removeAll();
                panel.add(topPanel, BorderLayout.NORTH);
                panel.add(calisanListesiniGoster(), BorderLayout.CENTER);
                panel.add(buttonPanelOlustur(), BorderLayout.SOUTH);
                frame.revalidate();
                frame.repaint();
            }
        });

        panel.add(buttonPanelOlustur(), BorderLayout.SOUTH);

        frame.add(panel);
        frame.setVisible(true);


    }

    private void urunSepetiEkle() {
        try {
            String idString = JOptionPane.showInputDialog(frame, "Ürün ID'sini girin:");
            int urunId = Integer.parseInt(idString);
            Urun urun = urunBul(urunId);
            if (urun != null) {
                alisverisSepeti.urunEkle(urun);
                JOptionPane.showMessageDialog(frame, "Ürün sepete eklendi: " + urun.getAd());
            } else {
                JOptionPane.showMessageDialog(frame, "Belirtilen ID'ye sahip bir ürün bulunamadı.");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(frame, "Geçersiz ID formatı.");
        }
    }
    private Urun urunBul(int urunId) {
        for (Urun urun : urunListesi) {
            if (urun.getUrunId() == urunId) {
                return urun;
            }
        }
        return null;
    }

    private void urunListesiGoster() {
        if (!alisverisSepeti.getAlisverisSepeti().isEmpty()) {
            JPanel listPanel = new JPanel();
            listPanel.setLayout(new BorderLayout());

            JLabel urunlerLabel = new JLabel("<html><b>Alışveriş Listesi:</b></html>");
            urunlerLabel.setFont(new Font("Arial", Font.BOLD, 16));
            listPanel.add(urunlerLabel, BorderLayout.NORTH);

            DefaultTableModel tableModel = new DefaultTableModel();
            tableModel.addColumn("Ürün ID");
            tableModel.addColumn("Ürün Adı");
            tableModel.addColumn("Fiyat");

            for (Urun urun : alisverisSepeti.getAlisverisSepeti()) {
                Object[] row = {urun.getUrunId(), urun.getAd(), urun.getFiyat()};
                tableModel.addRow(row);
            }

            JTable urunTable = new JTable(tableModel);
            JScrollPane scrollPane = new JScrollPane(urunTable);
            listPanel.add(scrollPane, BorderLayout.CENTER);

            JOptionPane.showMessageDialog(frame, listPanel);
        } else {
            JOptionPane.showMessageDialog(frame, "Alışveriş listesi boş.");
        }
    }



    private JPanel eklePanelOlustur() {
        urunEklePanel = new JPanel();
        urunEklePanel.setLayout(new GridLayout(6, 2));

        urunEklePanel.add(new JLabel("<html><b>Ürün Adı:</b></html>"));
        JTextField adField = new JTextField();
        urunEklePanel.add(adField);

        urunEklePanel.add(new JLabel("<html><b>Marka:</b></html>"));
        JTextField markaField = new JTextField();
        urunEklePanel.add(markaField);

        urunEklePanel.add(new JLabel("<html><b>Fiyat:</b></html>"));
        JTextField fiyatField = new JTextField();
        urunEklePanel.add(fiyatField);

        urunEklePanel.add(new JLabel("<html><b>Ürün Çeşidi:</b></html>"));
        JTextField cesidiField = new JTextField();
        urunEklePanel.add(cesidiField);

        urunEklePanel.add(new JLabel("<html><b>Stok Miktarı:</b></html>"));
        JTextField stokMiktariField = new JTextField();
        urunEklePanel.add(stokMiktariField);

        JButton ekleButton = new JButton("<html><b>Ekle</b></html>");
        ekleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                urunEkle(adField.getText(), markaField.getText(), Double.parseDouble(fiyatField.getText()),
                        cesidiField.getText(), Integer.parseInt(stokMiktariField.getText()));
            }
        });
        urunEklePanel.add(ekleButton);

        return urunEklePanel;
    }

    private void urunEkle(String ad, String marka, double fiyat, String cesidi, int stokMiktari) {
        Urun yeniUrun = new Urun(ad, marka, fiyat, cesidi, stokMiktari);
        urunListesi.add(yeniUrun);
        JOptionPane.showMessageDialog(frame, "Ürün Başarıyla Eklendi!");

        panel.removeAll();
        panel.add(topPanel, BorderLayout.NORTH);
        panel.add(buttonPanelOlustur(), BorderLayout.SOUTH);
        frame.revalidate();
        frame.repaint();
    }
    private void kullaniciEkle(String ad, String soyad, int id, Object ekstraBilgi, int kullaniciTipi) {
        if (kullaniciTipi == 1) {
            Musteri musteri = new Musteri(ad, soyad, id, (String) ekstraBilgi);
            musteriListesi.add(musteri);
            JOptionPane.showMessageDialog(frame, "Müşteri eklendi: " + musteri.getFirstName() + " " + musteri.getLastName());
        } else if (kullaniciTipi == 2) {
            Calisan calisan = new Calisan(ad, soyad, id, (Double) ekstraBilgi);
            calisanListesi.add(calisan);
            JOptionPane.showMessageDialog(frame, "Çalışan eklendi: " + calisan.getFirstName() + " " + calisan.getLastName());
        }

        panel.removeAll();
        panel.add(topPanel, BorderLayout.NORTH);
        panel.add(buttonPanelOlustur(), BorderLayout.SOUTH);
        frame.revalidate();
        frame.repaint();
    }

    private JPanel sorgulaPanelOlustur() {
        if (urunListesi.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Henüz hiç ürün eklenmemiş.");
        } else {
            JPanel sorgulaPanel = new JPanel();
            sorgulaPanel.setLayout(new BorderLayout());

            JLabel urunlerLabel = new JLabel("<html><b>Stoktaki Ürünler:</b></html>");
            urunlerLabel.setFont(new Font("Arial", Font.BOLD, 16));
            sorgulaPanel.add(urunlerLabel, BorderLayout.NORTH);

            DefaultTableModel tableModel = new DefaultTableModel();
            tableModel.addColumn("Ürün ID");
            tableModel.addColumn("Ürün Adı");
            tableModel.addColumn("Marka");
            tableModel.addColumn("Fiyat");
            tableModel.addColumn("Ürün Çeşidi");
            tableModel.addColumn("Stok Miktarı");

            for (Urun urun : urunListesi) {
                Object[] row = {urun.getUrunId(), urun.getAd(), urun.getMarka(),
                        urun.getFiyat(), urun.getUrunCesidi(), urun.getStokMiktari()};
                tableModel.addRow(row);
            }

            urunTable = new JTable(tableModel);
            JScrollPane scrollPane = new JScrollPane(urunTable);
            sorgulaPanel.add(scrollPane, BorderLayout.CENTER);

            return sorgulaPanel;
        }
        return new JPanel(); // Eğer ürün listesi boşsa boş bir panel döndür
    }

    private JPanel musteriListesiniGoster() {
        if (musteriListesi.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Henüz müşteri eklenmemiş.");
        } else {
            JPanel musteriSorgulaPanel = new JPanel();
            musteriSorgulaPanel.setLayout(new BorderLayout());

            JLabel musterilerLabel = new JLabel("<html><b>Müşteriler:</b></html>");
            musterilerLabel.setFont(new Font("Arial", Font.BOLD, 16));
            musteriSorgulaPanel.add(musterilerLabel, BorderLayout.NORTH);

            DefaultTableModel tableModel = new DefaultTableModel();
            tableModel.addColumn("Ad");
            tableModel.addColumn("Soyad");
            tableModel.addColumn("Müşteri ID");
            tableModel.addColumn("E-Posta");

            for (Musteri musteri : musteriListesi) {
                Object[] row = {musteri.getFirstName(), musteri.getLastName(), musteri.getMusteriId(), musteri.getePosta()};
                tableModel.addRow(row);
            }

            musteriTable = new JTable(tableModel);
            JScrollPane scrollPane = new JScrollPane(musteriTable);
            musteriSorgulaPanel.add(scrollPane, BorderLayout.CENTER);

            return musteriSorgulaPanel;
        }
        return new JPanel();
    }
    private JPanel calisanListesiniGoster() {
        if (calisanListesi.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Henüz çalışan eklenmemiş.");
        } else {
            JPanel calisanSorgulaPanel = new JPanel();
            calisanSorgulaPanel.setLayout(new BorderLayout());

            JLabel calisanlarLabel = new JLabel("<html><b>Çalışanlar:</b></html>");
            calisanlarLabel.setFont(new Font("Arial", Font.BOLD, 16));
            calisanSorgulaPanel.add(calisanlarLabel, BorderLayout.NORTH);

            DefaultTableModel tableModel = new DefaultTableModel();
            tableModel.addColumn("Ad");
            tableModel.addColumn("Soyad");
            tableModel.addColumn("Çalışan ID");
            tableModel.addColumn("Maaş");

            for (Calisan calisan : calisanListesi) {
                Object[] row = {calisan.getFirstName(), calisan.getLastName(), calisan.getCalisanId(), calisan.getSalary()};
                tableModel.addRow(row);
            }

            calisanTable = new JTable(tableModel);
            JScrollPane scrollPane = new JScrollPane(calisanTable);
            calisanSorgulaPanel.add(scrollPane, BorderLayout.CENTER);

            return calisanSorgulaPanel;
        }
        return new JPanel();
    }



    private JPanel kullaniciEklePanelOlustur(int kullaniciTipi) {
        JPanel kullaniciEklePanel = new JPanel();
        kullaniciEklePanel.setLayout(new GridLayout(6, 2));

        kullaniciEklePanel.add(new JLabel("<html><b>Ad:</b></html>"));
        JTextField adField = new JTextField();
        kullaniciEklePanel.add(adField);


        kullaniciEklePanel.add(new JLabel("<html><b>Soyad:</b></html>"));
        JTextField soyadField = new JTextField();
        kullaniciEklePanel.add(soyadField);

        if (kullaniciTipi == 1) { // Müşteri için özel alanlar
            kullaniciEklePanel.add(new JLabel("<html><b>Müşteri ID:</b></html>"));
            JTextField musteriIdField = new JTextField();
            kullaniciEklePanel.add(musteriIdField);

            kullaniciEklePanel.add(new JLabel("<html><b>E-posta:</b></html>"));
            JTextField ePostaField = new JTextField();
            kullaniciEklePanel.add(ePostaField);

            JButton ekleButton = new JButton("<html><b>Ekle</b></html>");
            ekleButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    kullaniciEkle(adField.getText(), soyadField.getText(),
                            Integer.parseInt(musteriIdField.getText()), ePostaField.getText(), kullaniciTipi);
                }
            });
            kullaniciEklePanel.add(ekleButton);
        } else if (kullaniciTipi == 2) { // Çalışan için özel alanlar
            kullaniciEklePanel.add(new JLabel("<html><b>Çalışan ID:</b></html>"));
            JTextField calisanIdField = new JTextField();
            kullaniciEklePanel.add(calisanIdField);

            kullaniciEklePanel.add(new JLabel("<html><b>Maaş:</b></html>"));
            JTextField maasField = new JTextField();
            kullaniciEklePanel.add(maasField);

            JButton ekleButton = new JButton("<html><b>Ekle</b></html>");
            ekleButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    kullaniciEkle(adField.getText(), soyadField.getText(),
                            Integer.parseInt(calisanIdField.getText()), Double.parseDouble(maasField.getText()), kullaniciTipi);
                }
            });
            kullaniciEklePanel.add(ekleButton);
        }

        return kullaniciEklePanel;
    }



    private JPanel buttonPanelOlustur() {
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(6, 1));
        buttonPanel.add(ekleButton);
        buttonPanel.add(sorgulaButton);
        buttonPanel.add(silButton);
        buttonPanel.add(alisverisSepetiButton);
        buttonPanel.add(alisverisListesiButton);
        buttonPanel.add(musteriEkleButton);
        buttonPanel.add(calisanEkleButton);
        buttonPanel.add(musteriListesiButton);
        buttonPanel.add(calisanListesiButton);
        return buttonPanel;
    }







    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new AraYuz();
            }
        });
    }
}

