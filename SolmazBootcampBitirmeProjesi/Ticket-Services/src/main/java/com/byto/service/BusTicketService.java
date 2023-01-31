package com.byto.service;

import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.byto.dto.BusExpeditionDto;
import com.byto.dto.BusTicketDto;
import com.byto.dto.UserDto;
import com.byto.model.BusExpedition;
import com.byto.model.BusTicket;
import com.byto.model.User;
import com.byto.repository.BusTicketRepository;


@Service
public class BusTicketService {

    @Autowired
    private BusTicketRepository busTicketRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private BusExpeditionService busExpeditionService;

    @Autowired
    private ModelMapper modelMapper;


    @Transactional
    public List<BusTicketDto> buyTicket(BusTicketDto busTicketDto) { // İstenilen şartlara göre bilet satın alıyor

        UserDto user = userService.getUserById(busTicketDto.getUserId());

        BusExpeditionDto exp = busExpeditionService.getById(busTicketDto.getExpeditionId());


        if (busTicketRepository.countByBusExpeditionId(busTicketDto.getExpeditionId()) < 45) { //Otobüs yolcu kapasitesi: 45

            if (user.getState().equals("INDIVIDUAL")) { // Bireysel kullanıcı aynı sefer için en fazla 5 bilet alabilir.


                Long count = busTicketRepository.countByBusExpeditionIdAndUserId(busTicketDto.getExpeditionId(), busTicketDto.getUserId());


                if (count < 5) { // en fazla 5 bilet alabilir.


                    if (busTicketDto.getGender().equals("Male")) { //erkekse

                        if (busTicketDto.getPersonCount() > (5 - count)) {
                            System.out.println("UYARI! Toplamda  " + (5 - count) + " kadar bilet isteyebilirsiniz!");
                        } else {

                            if (busTicketDto.getPersonCount() > 2) {
                                System.out.println("Erkek icin en fazla 2 bile alabilirsiniz");
                            } else {

                                for (int i = 0; i < busTicketDto.getPersonCount(); i++) {

                                    if (count < 5) {

                                        BusTicket busTicket = new BusTicket();

                                        busTicket.setBusExpedition(modelMapper.map(exp, BusExpedition.class));

                                        busTicket.setUser(modelMapper.map(user, User.class));

                                        busTicket.setGender(busTicketDto.getGender());

                                        busTicketRepository.save(busTicket);

                                        count++;
                                    }


                                }

                            }

                        }
                    } else {//kadınsa

                        if (busTicketDto.getPersonCount() > (5 - count)) {
                            System.out.println("UYARI! Toplamda  " + (5 - count) + " kadar bilet isteyebilirsiniz!");
                        } else {
                            if (busTicketDto.getPersonCount() > 5) {
                                System.out.println("Tek seferde En fazla 5 bile alabilirsiniz");
                            } else {

                                for (int i = 0; i < busTicketDto.getPersonCount(); i++) {

                                    if (count < 5) {

                                        BusTicket busTicket = new BusTicket();

                                        busTicket.setBusExpedition(modelMapper.map(exp, BusExpedition.class));

                                        busTicket.setUser(modelMapper.map(user, User.class));


                                        busTicket.setGender(busTicketDto.getGender());

                                        busTicketRepository.save(busTicket);

                                        count++;
                                    }


                                }


                            }
                        }

                    }


                }

            }


            if (user.getState().equals("CORPORATE")) { //Kurumsal kullanıcı aynı sefer için en fazla 20 bilet alabilir.

                Long count = busTicketRepository.countByBusExpeditionIdAndUserId(busTicketDto.getExpeditionId(), busTicketDto.getUserId());

                if (busTicketDto.getPersonCount() > (20 - count)) {
                    System.out.println("UYARI! Toplamda  " + (20 - count) + " kadar bilet isteyebilirsiniz!");
                } else {

                    if (count < 20) {

                        for (int i = 0; i < busTicketDto.getPersonCount(); i++) {

                            if (count < 20) {

                                BusTicket busTicket = new BusTicket();

                                busTicket.setBusExpedition(modelMapper.map(exp, BusExpedition.class));

                                busTicket.setUser(modelMapper.map(user, User.class));


                                busTicket.setGender(busTicketDto.getGender());

                                busTicketRepository.save(busTicket);

                                count++;
                            }


                        }


                    }

                }


            }


        }

        List<BusTicket> lists = busTicketRepository.findByBusExpeditionIdAndUserId(busTicketDto.getExpeditionId(), busTicketDto.getUserId());
        List<BusTicketDto> liste = new ArrayList<>();

        for (BusTicket busTicket : lists) {

            liste.add(modelMapper.map(busTicket, BusTicketDto.class));

        }

        return liste;

    }


    public List<BusTicketDto> getTicket(Long id) {   //verilen id ye göre bileti getiriyor

        List<BusTicket> busTickets = busTicketRepository.findAllById(id);

        List<BusTicketDto> busTicketDtos = new ArrayList<>();

        for (BusTicket item : busTickets) {

            busTicketDtos.add(modelMapper.map(item, BusTicketDto.class));

        }


        return busTicketDtos;
    }


}
