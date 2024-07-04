package com.seumelhorcaminho.produtividade.estudos.model

data class Email(
    val user: String,
    val subject: String,
    val prev: String,
    val date: String,
    val star: Boolean,
    val unread: Boolean,
    var selected: Boolean = false
)

class EmailBuilder {
    var user: String = ""
    var subject: String = ""
    var prev: String = ""
    var date: String = ""
    var star: Boolean = false
    var unread: Boolean = false

    fun build(): Email = Email(user,subject,prev,date,star,unread,false)
}
    fun email(block: EmailBuilder.() -> Unit): Email = EmailBuilder().apply(block).build()

fun fakeEmails(): MutableList<Email> = mutableListOf(
    email {
        user = "Facebook"
        subject = "Confirmação de login na sua conta Facebook"
        prev = "Olá, você realizou um login na sua conta do Facebook recentemente. Caso não tenha sido você, entre em contato conosco."
        date = "12 ago"
        unread = true
        star = false
    },
    email {
        user = "Instagram"
        subject = "Notificação de atividade na sua conta Instagram"
        prev = "Você tem uma nova mensagem no Instagram. Clique aqui para visualizar."
        date = "10 ago"
        unread = false
        star = true
    },
    email {
        user = "Google"
        subject = "Atualização importante sobre a sua conta Google"
        prev = "Caro usuário, detectamos atividades incomuns na sua conta Google. Por favor, verifique suas configurações de segurança."
        date = "05 ago"
        unread = false
        star = false
    },
    email {
        user = "Indaia"
        subject = "Promoção de Verão - Descontos Imperdíveis!"
        prev = "Olá! Aproveite nossas ofertas exclusivas de verão. Clique aqui para conferir."
        date = "12 jan"
        unread = false
        star = false
    },
    email {
        user = "Samsung"
        subject = "Atualização de Software Disponível para o seu dispositivo"
        prev = "Uma nova atualização de software está disponível para o seu dispositivo Samsung. Clique para atualizar agora."
        date = "12 jul"
        unread = true
        star = false
    },
    email {
        user = "Livraria Cultura"
        subject = "Confirmação de Pedido na Livraria Online"
        prev = "O seu pedido foi confirmado. Em breve você receberá um e-mail com os detalhes de entrega."
        date = "12 ago"
        unread = false
        star = true
    },
    email {
        user = "Facebook"
        subject = "Confirmação de login na sua conta Facebook"
        prev = "Olá, você realizou um login na sua conta do Facebook recentemente. Caso não tenha sido você, entre em contato conosco."
        date = "12 ago"
        unread = true
        star = false
    },
    email {
        user = "Instagram"
        subject = "Notificação de atividade na sua conta Instagram"
        prev = "Você tem uma nova mensagem no Instagram. Clique aqui para visualizar."
        date = "10 ago"
        unread = false
        star = true
    },
    email {
        user = "Google"
        subject = "Atualização importante sobre a sua conta Google"
        prev = "Caro usuário, detectamos atividades incomuns na sua conta Google. Por favor, verifique suas configurações de segurança."
        date = "05 ago"
        unread = false
        star = false
    },
    email {
        user = "contato@indaia.com"
        subject = "Promoção de Verão - Descontos Imperdíveis!"
        prev = "Olá! Aproveite nossas ofertas exclusivas de verão. Clique aqui para conferir."
        date = "12 jan"
        unread = false
        star = false
    },
    email {
        user = "noreply@samsung.com"
        subject = "Atualização de Software Disponível para o seu dispositivo"
        prev = "Uma nova atualização de software está disponível para o seu dispositivo Samsung. Clique para atualizar agora."
        date = "12 jul"
        unread = true
        star = false
    }
)



