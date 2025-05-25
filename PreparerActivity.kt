import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class PreparerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_preparer)

        val shopsBtn = findViewById<Button>(R.id.myShopsBtn)
        val ordersBtn = findViewById<Button>(R.id.myOrdersBtn)
        val walletBtn = findViewById<Button>(R.id.myWalletBtn)

        shopsBtn.setOnClickListener {
            Toast.makeText(this, "فتح المحلات الخاصة بك", Toast.LENGTH_SHORT).show()
            // لاحقًا نعرض فقط المحلات المخصصة لهذا المجهز
        }

        ordersBtn.setOnClickListener {
            Toast.makeText(this, "عرض الطلبات المرسلة لك", Toast.LENGTH_SHORT).show()
            // لاحقًا نعرض فقط الطلبات الخاصة به
        }

        walletBtn.setOnClickListener {
            val walletUrl = "https://your-wallet-link.com"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(walletUrl))
            startActivity(intent)
        }
    }
}