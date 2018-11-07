- Apa fungsi BCryptPasswordEncoder?
    BCryptPasswordEncoder merupakan kelas untuk melakukan encoding dengan metode BCrypt agar password tidak disimpan dalam bentuk plain text

- Apa yang dilakukan baris berikut? (Method pada kelas
UserDetailsServiceImpl.java)

    Set<GrantedAuthority> grantedAuthoritySet = new HashSet<>();
    grantedAuthoritySet.add(new SimpleGrantedAuthority(user.getRole()));

Set tersebut berfungsi untuk mendefinisikan otoritas dari setiap role user. Set ini nantinya akan digunakan oleh class User setiap ada request dari user tersebut.
    
