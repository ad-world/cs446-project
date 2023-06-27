package clarity.backend.controllers

import clarity.backend.entity.*
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class CardController {

    @PostMapping("/addCardToSet")
    fun addCardToSet(@RequestBody card: AddCard) : ResponseEntity<String> {
        val resp = CardSetEntity().addCardToSet(card)
        return if (resp.response == StatusResponse.Success) {
            ResponseEntity.ok(resp.msg)
        } else {
            ResponseEntity.badRequest().body(resp.msg)
        }
    }

    @PostMapping("/deleteCardFromSet")
    fun deleteCardFromSet(@RequestBody card: DeleteCard) : ResponseEntity<String> {
        val resp = CardSetEntity().deleteCardFromSet(card)
        return if (resp.response == StatusResponse.Success) {
            ResponseEntity.ok(resp.msg)
        } else {
            ResponseEntity.badRequest().body(resp.msg)
        }
    }

    @PostMapping("/addSet")
    fun addSet(@RequestBody cardSetEntity: CreateCardSetEntity) : ResponseEntity<String> {
        val resp = CardSetEntity().createCardSet(cardSetEntity)
        return if (resp.response == StatusResponse.Success) {
            ResponseEntity.ok(resp.msg)
        } else {
            ResponseEntity.badRequest().body(resp.msg)
        }
    }

    @PostMapping("/getCardsForSet")
    fun getCards(@RequestBody set: GetCardsInSet) : ResponseEntity<List<String>> {
        val resp = CardSetEntity().getTotalCardsFromSet(set)
        return if (resp.response == StatusResponse.Success) {
            ResponseEntity.ok(resp.cards)
        } else {
            ResponseEntity.badRequest().body(resp.cards)
        }
    }

    @GetMapping("/getSets")
    fun getAllSets() : ResponseEntity<List<String>> {
        val resp = CardSetEntity().getSets()
        return if (resp.response == StatusResponse.Success) {
            ResponseEntity.ok(resp.sets)
        } else {
            ResponseEntity.badRequest().body(resp.sets)
        }
    }
}