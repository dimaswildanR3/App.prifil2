package com.example.appprifil

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
//import android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    var edtName : EditText? = null
    var spinnerGender : Spinner? = null
    var edtEmail : EditText? = null
    var edtTelp : EditText? = null
    var edtAlamat : EditText? = null
    var btnSave :Button? = null
    var edtAddress :EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

     btnSave.setOnClickListener(){
         ValidasiInput()
     }
        setDataSpinerGender()}

    private fun setDataSpinerGender() {
        TODO("Not yet implemented")
        val adapter = ArrayAdapter.createFromResource(
                this,
                R.array.gender_list, android.R.layout.simple_spinner_item
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerGender.adapter = adapter


    }

    private fun ValidasiInput() {
        TODO("Not yet implemented")
        val namaInput = edtName.toString()
        val emailInput = edtEmail.toString()
        val telpInput = edtTelp.toString()
        val alamatInput = edtAddress.toString()
        val genderInput = spinnerGender.toString()

        when {
            namaInput.isEmpty() -> edtName.error = "Nama tidak boleh kosong"
            genderInput.equals("Pilih Jenis Kelamin") -> Toast.makeText(
                    this,
                    "Jenis kelamin harus dipilih",
                    Toast.LENGTH_SHORT
            ).show()
            emailInput.isEmpty() -> edtEmail.error= "Email tidak boleh kosong"
            telpInput.isEmpty() -> edtTelp.error = "Telp tidak boleh kosong"
            alamatInput.isEmpty() -> edtAddress.error = "Alamat tidak boleh kosong"

            else -> {
                Toast.makeText(
                        this, "Navigasi ke halaman profil diri", Toast.LENGTH_SHORT
                ).show()
                NavigasiProfilDiri()
            }

        }
    }

    private fun NavigasiProfilDiri() {
        TODO("Not yet implemented")

        val intent = Intent(this, MyProfileActivity::class.java)
        val bundle = Bundle()
        val namaInput = edtName.toString()
        val emailInput = edtEmail.toString()
        val telpInput = edtTelp.toString()
        val alamatInput = edtAddress.toString()
        val genderInput = spinnerGender.toString()

        bundle.putString("nama", namaInput)
        bundle.putString("gender", genderInput)
        bundle.putString("email", emailInput)
        bundle.putString("telp", telpInput)
        bundle.putString("alamat", alamatInput)
        intent.putExtras(bundle)
        startActivity(intent)
    }

}

