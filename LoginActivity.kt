import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    private val passwords = mapOf(
        "AHMED38" to "admin",
        "MUSEN12" to "preparer",
        "FSRES29" to "courier"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val input = findViewById<EditText>(R.id.passwordInput)
        val button = findViewById<Button>(R.id.loginButton)

        val prefs = getSharedPreferences("app_prefs", MODE_PRIVATE)

        // إذا كان الرمز محفوظ مسبقًا، نفتح الشاشة المناسبة
        val savedRole = prefs.getString("user_role", null)
        if (savedRole != null) {
            goToRole(savedRole)
            return
        }

        button.setOnClickListener {
            val code = input.text.toString().trim()
            val role = passwords[code]
            if (role != null) {
                prefs.edit().putString("user_role", role).apply()
                goToRole(role)
            } else {
                Toast.makeText(this, "رمز غير صحيح", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun goToRole(role: String) {
    val intent = when (role) {
        "admin" -> Intent(this, AdminActivity::class.java)
        "preparer" -> Intent(this, PreparerActivity::class.java)
        "courier" -> Intent(this, CourierActivity::class.java)
        else -> null
    }
    intent?.let {
        startActivity(it)
        finish()
    }
}
}