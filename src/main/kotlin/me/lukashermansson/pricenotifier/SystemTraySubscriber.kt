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

        val tray = SystemTray.getSystemTray()

        val image: Image = Toolkit.getDefaultToolkit().createImage("icon.png")

        val trayIcon = TrayIcon(image, "Tray Demo")

        trayIcon.isImageAutoSize = true
        //Set tooltip text for the tray icon
        trayIcon.toolTip = "PriceNotifier"
        tray.add(trayIcon)
        trayIcon.displayMessage("Pris", "Nytt pris: $price", MessageType.INFO)
    }
}