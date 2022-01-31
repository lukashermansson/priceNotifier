package me.lukashermansson.pricenotifier

import org.springframework.stereotype.Component
import java.awt.*
import java.awt.TrayIcon.MessageType
import javax.annotation.PostConstruct


@Component
class SystemTraySubscriber(val subscriber: Scheduler) {

    @PostConstruct
    fun e() {
        subscriber.subscribers += {

            displayTray(it)
        }
    }


    fun displayTray(price: Price) {
        //Obtain only one instance of the SystemTray object
        val tray = SystemTray.getSystemTray()

        //If the icon is a file
        val image: Image = Toolkit.getDefaultToolkit().createImage("icon.png")
        //Alternative (if the icon is on the classpath):
        //Image image = Toolkit.getDefaultToolkit().createImage(getClass().getResource("icon.png"));
        val trayIcon = TrayIcon(image, "Tray Demo")
        //Let the system resize the image if needed
        trayIcon.isImageAutoSize = true
        //Set tooltip text for the tray icon
        trayIcon.toolTip = "PriceNotifier"
        tray.add(trayIcon)
        trayIcon.displayMessage("Pris", "Nytt pris: ${price.amount} kr", MessageType.INFO)
    }
}