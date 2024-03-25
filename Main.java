package work;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        
        // Kullanıcıyı karşılayan mesajı yazdırır
        System.out.println("Havayolu şirketine hoş geldiniz.");
        // Kullanıcıya destinasyon seçeneklerini gösterir
        System.out.println("Nereye uçmak istersiniz?\n 1- İstanbul\n 2- Madrid\n 3- Roma\n 4- Budapeşte");
        // Kullanıcının seçimini alır
        int nereye = userInput.nextInt();
        
        int gidisFiyat, donusFiyat, toplamFiyat;
        // Kullanıcının seçtiği destinasyona göre gidiş ve dönüş fiyatlarını belirler
        if (nereye == 1) { // İstanbul
            gidisFiyat = 273;
            donusFiyat = 273;
        } else if (nereye == 2) { // Madrid
            gidisFiyat = 320;
            donusFiyat = 320;
        } else if (nereye == 3) { // Roma
            gidisFiyat = 400;
            donusFiyat = 400;
        } else if (nereye == 4) { // Budapeşte
            gidisFiyat = 200;
            donusFiyat = 200;
        } else {
            // Geçersiz bir seçim yapıldığında kullanıcıyı uyarır ve programı sonlandırır
            System.out.println("Geçersiz bir seçim yaptınız.");
            return;
        }
        
        // Kullanıcıya uçuş tipi seçeneklerini gösterir
        System.out.println("Uçuşunuz tek yön mü, gidiş dönüş mü olacak?\n 1- Tek Yön\n 2- Gidiş Dönüş");
        // Kullanıcının seçimini alır
        int ucusTercihi = userInput.nextInt();
 
        if (ucusTercihi == 1) {
            // Tek yönlü uçuş için toplam fiyatı gidiş fiyatı olarak belirler
            toplamFiyat = gidisFiyat;
        } else if (ucusTercihi == 2) {
            // Gidiş dönüş uçuşu için toplam fiyatı gidiş ve dönüş fiyatlarının toplamı olarak belirler
            toplamFiyat = gidisFiyat + donusFiyat;
        } else {
            // Geçersiz bir seçim yapıldığında kullanıcıyı uyarır ve programı sonlandırır
            System.out.println("Geçersiz bir seçim yaptınız.");
            return;
        }
 
        // Kullanıcıya bilet fiyatını gösterir
        System.out.println("Bilet fiyatı: " + toplamFiyat + "$");
 
        int toplamYolcuFiyati = 0;
        while (true) {
            // Kullanıcıdan yolcu bilgilerini alır
            System.out.println("Yolcu bilgilerini giriniz.");
            System.out.print("Ad: ");
            String ad = userInput.next();
            System.out.print("Soyad: ");
            String soyad = userInput.next();
            System.out.print("Yaş: ");
            int yas = userInput.nextInt();
            int fiyat = toplamFiyat;
 
            if (yas < 12) {
                // Yolcu 12 yaşından küçükse %50 indirim uygular
                fiyat *= 0.5;
                System.out.println("Yolcu 12 yaşından küçük olduğu için %50 indirim uygulandı.\n" + "İndirimli fiyat: " + fiyat + "$");
            } else if (yas >= 12 && yas <= 24) {
                // Yolcu 12-24 yaş arasındaysa %10 indirim uygular
                fiyat *= 0.9;
                System.out.println("Yolcu 12-24 yaş arasında olduğu için %10 indirim uygulandı.\n" + "İndirimli fiyat: " + fiyat + "$");
            } else if (yas >= 65) {
                // Yolcu 65 yaş ve üstündeyse %30 indirim uygular
                fiyat *= 0.7;
                System.out.println("Yolcu 65 yaş ve üstü olduğu için %30 indirim uygulandı.\n" + "İndirimli fiyat:" + fiyat + "$");
            }
 
            // Yolcunun bilgilerini ve bileti oluşturduğuna dair mesajı gösterir
            System.out.println(ad + " " + soyad + " adlı yolcunun bileti oluşturuldu.");
 
            // Toplam yolcu fiyatını günceller
            toplamYolcuFiyati += fiyat;
 
            // Başka bir yolcu eklemek isteyip istemediğini sorar
            System.out.println("Başka bir yolcu eklemek ister misiniz? (Evet/Hayır)");
            String devam = userInput.next();
            if (!devam.equalsIgnoreCase("Evet")) {
                break;
            }
        }
        // Toplam ödenecek tutarı gösterir
        System.out.println("Toplam ödenecek tutar: " + toplamYolcuFiyati + "$");
        // Ödeme seçeneklerini sunar ve kullanıcının seçimini alır
        System.out.println("1- Satın Al\t\t 2-Çıkış Yap");
        int secim = userInput.nextInt();
        if (secim == 1) {
            // Kullanıcı ödeme yapmayı seçerse başarılı bir ödeme mesajı gösterir
            System.out.println("Ödeme başarıyla tamamlandı.\n İyi yolculuklar.");
        } else {
            // Kullanıcı çıkış yapmayı seçerse programı sonlandırır
            System.exit(secim);
        }
    }
}
