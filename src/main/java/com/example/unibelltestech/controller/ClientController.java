package com.example.unibelltestech.controller;

import com.example.unibelltestech.dto.ClientDto;
import com.example.unibelltestech.dto.ContactDto;
import com.example.unibelltestech.dto.CreateClientDto;
import com.example.unibelltestech.dto.CreateContactDto;
import com.example.unibelltestech.model.Contact.ContactType;
import com.example.unibelltestech.service.ClientService;
import com.example.unibelltestech.service.ContactService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController {
    private final ClientService clientService;
    private final ContactService contactService;

    public ClientController(ClientService clientService, ContactService contactService) {
        this.clientService = clientService;
        this.contactService = contactService;
    }

    @Operation(
            summary = "Create a new client",
            description = "Endpoint to create a new client",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Client created successfully",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = ClientDto.class)
                            )
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Bad request or invalid data"
                    )
            }
    )
    @PostMapping
    public ResponseEntity<ClientDto> createClient(@io.swagger.v3.oas.annotations.parameters.RequestBody
                                                          (description = "New client data", required = true)
                                                  @RequestBody CreateClientDto client) {
        return ResponseEntity.ok(clientService.createClient(client));
    }

    @Operation(
            summary = "Add a contact to a client",
            description = "Endpoint to add a new contact to a client",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Contact added successfully",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = ClientDto.class)
                            )
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Bad request or invalid data"
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Client not found"
                    )
            }
    )
    @PostMapping("/{clientId}/contacts")
    public ResponseEntity<ClientDto> addContact(@Parameter(description = "Client ID", required = true)
                                                @PathVariable("clientId") Long clientId,
                                                @io.swagger.v3.oas.annotations.parameters.RequestBody(
                                                        description = "New contact data", required = true)
                                                @RequestBody CreateContactDto newContact) {
        return ResponseEntity.ok(clientService.addContactToClient(clientId, newContact));
    }

    @Operation(
            summary = "Get all clients",
            description = "Endpoint to retrieve all clients",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Clients retrieved successfully",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    array = @ArraySchema(schema = @Schema(implementation = ClientDto.class))
                            )
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Bad request or invalid data"
                    )
            }
    )
    @GetMapping()
    public ResponseEntity<List<ClientDto>> getAllClients() {
        return ResponseEntity.ok(clientService.getAllClients());
    }

    @Operation(
            summary = "Get a client by ID",
            description = "Endpoint to retrieve a client by its ID",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Client retrieved successfully",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = ClientDto.class)
                            )
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Client not found"
                    )
            }
    )
    @GetMapping("/{clientId}")
    public ResponseEntity<ClientDto> getClientById(@Parameter(description = "Client ID", required = true)
                                                   @PathVariable("clientId") Long clientId) {
        return ResponseEntity.ok(clientService.getById(clientId));
    }

    @Operation(
            summary = "Get all contacts of a client",
            description = "Endpoint to retrieve all contacts of a client",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Contacts retrieved successfully",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    array = @ArraySchema(schema = @Schema(implementation = ContactDto.class))
                            )
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Client not found"
                    )
            }
    )
    @GetMapping("/{clientId}/contacts")
    public ResponseEntity<List<ContactDto>> getAllContactByClientId(@Parameter(description = "Client ID", required = true)
                                                                    @PathVariable("clientId") Long clientId) {
        return ResponseEntity.ok(contactService.findAllByClientId(clientId));
    }

    @Operation(
            summary = "Get contacts of a client by type",
            description = "Endpoint to retrieve contacts of a client by type",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Contacts retrieved successfully",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    array = @ArraySchema(schema = @Schema(implementation = ContactDto.class))
                            )
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Client not found or no contacts of the specified type"
                    )
            }
    )
    @GetMapping("/{clientId}/contacts/{type}")
    public ResponseEntity<List<ContactDto>> getContactsByClientIdAndType(
            @Parameter(description = "Client ID", required = true)
            @PathVariable("clientId") Long clientId,
            @Parameter(description = "Contact type (PHONE_NUMBER or EMAIL)", required = true)
            @PathVariable("type") ContactType type) {
        return ResponseEntity.ok(contactService.findAllByClientIdAndType(clientId, type));
    }
}